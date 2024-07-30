package economy;

import com.toedter.calendar.JDateChooser;
import customer.conn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ecocontroller {

    Connection con1 = conn.connectdb();

    account acc;

    public ecocontroller() {
        acc = new account();
        acc.setVisible(true);

        acc.getBtnsearch().addActionListener((e) -> {
            DefaultTableModel model = (DefaultTableModel) acc.gettblacc().getModel();
            DefaultTableModel mode2 = (DefaultTableModel) acc.gettblacc1().getModel();
            
            model.setRowCount(0);
mode2.setRowCount(0);
            double sumcost = 0;
            double sumprice = 0;
            double profit = 0;
            double amount = 0;

            try {
                Statement stmt = con1.createStatement();
                java.util.Date startDate = acc.getd1().getDate();
                java.util.Date endDate = acc.getd2().getDate();

                // Create a SimpleDateFormat to format the dates for the query
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                // Construct the SELECT query with the date range for summary table
                String selectQuery = "SELECT * FROM summary WHERE DATE BETWEEN '" + dateFormat.format(startDate) + "' AND '" + dateFormat.format(endDate) + "'";
                
                try (ResultSet resultSet = stmt.executeQuery(selectQuery)) {
                    while (resultSet.next()) {
                        String code = resultSet.getString("item_code");
                        String name = resultSet.getString("item_name");
                        String qty = resultSet.getString("qty");
                        String cost = resultSet.getString("cost");
                        String price = resultSet.getString("price");

                        double pri = Double.parseDouble(price);
                        sumprice += pri;

                        double cos = Double.parseDouble(cost);
                        sumcost += cos;

                        String tbldata[] = {code, name, qty, cost, price};
                        DefaultTableModel tblModel1 = (DefaultTableModel) acc.gettblacc().getModel();

                        tblModel1.addRow(tbldata);
                    }
                }

                // Construct the SELECT query with the date range for expenditures table
                String selectQuery1 = "SELECT * FROM expenditures WHERE Date BETWEEN '" + dateFormat.format(startDate) + "' AND '" + dateFormat.format(endDate) + "'";
                
                try (ResultSet resultSet1 = stmt.executeQuery(selectQuery1)) {
                    while (resultSet1.next()) {
                        String date = resultSet1.getString("Date");
                        String detail = resultSet1.getString("Details");
                        String amount1 = resultSet1.getString("Amount");

                        double am = Double.parseDouble(amount1);
                        amount += am;

                        String tbldata2[] = {date, detail, amount1};
                        DefaultTableModel tblModel2 = (DefaultTableModel) acc.gettblacc1().getModel();

                        tblModel2.addRow(tbldata2);
                    }
                }

                profit = sumprice - (sumcost + amount);
                acc.getprofit().setText(Double.toString(profit));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Cannot execute the operation");
            }
        });

        acc.getbtnbck().addActionListener((e) -> {
            acc.dispose();
        });
    }
}
