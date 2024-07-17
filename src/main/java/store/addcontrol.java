package store;

import customer.conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class addcontrol {
    additem addi;
    storefront stfr;
    Connection con;

    public addcontrol() {
        stfr = new storefront();
        addi = new additem();
        addi.setVisible(true);
        con = conn.connectdb();

        addi.getadditm().addActionListener((e) -> {
            int code = Integer.parseInt(addi.getitemcode().getText());
            String name = addi.getitemname().getText();
            int qty = Integer.parseInt(addi.getitemqty().getText());
            Double cost = Double.parseDouble(addi.getitemcost().getText());
            Double price = Double.parseDouble(addi.getitemprice().getText());

            try {
                // Check if item with given code or name already exists
                String checkQuery = "SELECT * FROM items WHERE item_code = " + code + " OR item_name = '" + name + "'";
                Statement checkStmt = con.createStatement();
                ResultSet rs = checkStmt.executeQuery(checkQuery);

                if (rs.next()) {
                    // Item with same code or name already exists
                    JOptionPane.showMessageDialog(null, "Item with code or name already exists. Cannot add.");
                } else {
                    // Item does not exist, insert into database
                    String insertQuery = "INSERT INTO items(item_code, item_name, qtyinstock, cost, price) " +
                                         "VALUES(" + code + ", '" + name + "', " + qty + ", " + cost + ", " + price + ")";
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(insertQuery);

                    addi.getitemcode().setText("");
                    addi.getitemname().setText("");
                    addi.getitemqty().setText("");
                    addi.getitemcost().setText("");
                    addi.getitemprice().setText("");

                    JOptionPane.showMessageDialog(null, "Item added successfully.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Cannot execute the operation: " + ex.getMessage());
            }

        });

        addi.getbtnback().addActionListener((e) -> {
            addi.dispose();
        });
    }
}
