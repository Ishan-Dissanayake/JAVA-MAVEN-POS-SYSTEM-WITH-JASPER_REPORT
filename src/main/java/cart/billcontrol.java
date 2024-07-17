package cart;

import customer.conn;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class billcontrol {

    bill bil;
    double tot=0;
    PrinterJob printerJob;

    public billcontrol(){
        bil = new bill();
        bil.setVisible(true);
        Connection con1 = conn.connectdb();
        printerJob = PrinterJob.getPrinterJob();

          // Add a DocumentListener to txtitmcode
        bil.getcode().getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            public void removeUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            public void insertUpdate(DocumentEvent e) {
                updateSuggestions();
            }

            private void updateSuggestions() {
                String text = bil.getcode().getText();
                if (text.isEmpty()) {
                    bil.getListModel().clear();
                    return;
                }
                ArrayList<String> suggestions = fetchSuggestions(text, con1);
                bil.getListModel().clear();
                for (String suggestion : suggestions) {
                    bil.getListModel().addElement(suggestion);
                }
            }
        });
        
        // Action Listener for adding items to cart
        bil.getbtnsrch().addActionListener((e) -> {
            try {
                String searchcode = (bil.getcode().getText());
                int qt = Integer.parseInt(bil.gettxtqty().getText());

                Statement stmt1 = con1.createStatement();
                ResultSet reslt = stmt1.executeQuery("select * from items where item_name='" + searchcode + "'");
                while (reslt.next()) {
                    String code1 = reslt.getString(1);
                    String name1 = reslt.getString(2);
                    String qty1 = reslt.getString(3);
                    String cost1 = reslt.getString(4);
                    String price1 = reslt.getString(5);

                    double now = Double.parseDouble(qty1);
                    double nowqt = now - qt;

                    double am = Double.parseDouble(price1);
                    double amount = am * qt;

                    double amco = Double.parseDouble(cost1);
                    double amcost = amco * qt;

                    // Insert into cart table
                    String query = "insert into cart(item_code,item_name,qty,price)" +
                            "values(" + code1 + ",'" + name1 + "'," + qt + "," + amount + ")";
                    Statement stmt = con1.createStatement();
                    stmt.executeUpdate(query);

                    // Insert into summary table
                    String query3 = "insert into summary(item_code,item_name,qty,cost,price)" +
                            "values(" + code1 + ",'" + name1 + "'," + qty1 + "," + amcost + "," + amount + ")";
                    Statement stmt3 = con1.createStatement();
                    stmt3.executeUpdate(query3);

                    // Update items table
                    String query9 = "UPDATE items SET qtyinstock=" + nowqt + " WHERE item_name='" + searchcode + "'";
                    Statement stmt9 = con1.createStatement();
                    stmt9.executeUpdate(query9);

                    // Refresh cart table display
                    DefaultTableModel model = (DefaultTableModel) bil.getcart().getModel();
                    model.setRowCount(0);

                    Statement stmt5 = con1.createStatement();
                    ResultSet reslt1 = stmt5.executeQuery("select * from cart");
                    while (reslt1.next()) {
                        String code = reslt1.getString("item_code");
                        String name = reslt1.getString("item_name");
                        String qty = reslt1.getString("qty");
                        String price = reslt1.getString("price");

                        String tbldata[] = {code, name, qty, price};
                        DefaultTableModel tblModel1 = (DefaultTableModel) bil.getcart().getModel();

                        tblModel1.addRow(tbldata);
                    }

                    // Calculate total
                    Statement stmtTotal = con1.createStatement();
                    ResultSet rsTotal = stmtTotal.executeQuery("SELECT SUM(price) FROM cart");
                    if (rsTotal.next()) {
                        tot = rsTotal.getDouble(1);
                    }

                    bil.gettot().setText(Double.toString(tot));
                    bil.getcode().setText("");
                    bil.gettxtqty().setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Can not execute the operation");
            }
        });

        // Action Listener for completing the bill
        bil.getbtndone().addActionListener((e) -> {
            try {
                Statement stmt7 = con1.createStatement();
                String query7 = "TRUNCATE TABLE cart";
                stmt7.executeUpdate(query7);
                bil.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Can not execute the operation");
            }
        });

        // Action Listener for closing the bill window
        bil.getbtnclse().addActionListener((e) -> {
             try {
                Statement stmt7 = con1.createStatement();
                String query7 = "TRUNCATE TABLE cart";
                stmt7.executeUpdate(query7);
                bil.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Can not execute the operation");
            }
            bil.dispose();
        });

        // Action Listener for printing the bill
        bil.getbtnprint().addActionListener((e) -> {
           try {
    // Load the JasperDesign from .jrxml file
    String reportPath = "C:\\Users\\ASUS\\Downloads\\Compressed\\eadcw-20240708T213253Z-001\\eadcw\\src\\main\\java\\cart\\report2.jrxml";
    JasperDesign jdesign = JRXmlLoader.load(reportPath);

    // Set the SQL query
    String query = "SELECT * FROM cart";
    JRDesignQuery updateQuery = new JRDesignQuery();
    updateQuery.setText(query);
    jdesign.setQuery(updateQuery);

    // Compile the Jasper report
    JasperReport jreport = JasperCompileManager.compileReport(jdesign);

    // Fill the report with data from the database connection
    JasperPrint Jprint = JasperFillManager.fillReport(jreport, null, con1);

    // Print the report directly to the default printer
    JasperPrintManager.printReport(Jprint, false);
} catch (JRException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error printing the bill.");
}
        });
    }

    // Method to truncate string to fit within maximum width
    private String truncateStringToFit(String text, int maxWidth, Graphics2D g2d) {
        String truncatedText = text;
        int textWidth = g2d.getFontMetrics().stringWidth(text);
        if (textWidth > maxWidth) {
            while (textWidth > maxWidth) {
                truncatedText = truncatedText.substring(0, truncatedText.length() - 1);
                textWidth = g2d.getFontMetrics().stringWidth(truncatedText + "...");
            }
            truncatedText += "...";
        }
        return truncatedText;
    }
    
    private ArrayList<String> fetchSuggestions(String text, Connection con1) {
        ArrayList<String> suggestions = new ArrayList<>();
        try {
            Statement stmt = con1.createStatement();
            String query = "SELECT item_name FROM items WHERE item_name LIKE '%" + text + "%'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                suggestions.add(rs.getString("item_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suggestions;
    }
}
