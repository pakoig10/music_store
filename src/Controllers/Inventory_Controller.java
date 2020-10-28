package Controllers;

import Helpers.DBUtil;
import Models.Inventory;
import Views.Inventory_View;

import java.sql.*;

public class Inventory_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Inventory inventory = new Inventory();
            inventory = Inventory_View.setObject(inventory);
            String sql = "INSERT INTO inventory (quantity, outlet_outlet_number, product_product_code) VALUES (?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, inventory.getQuantity());
            stmt.setInt(2, inventory.getOutlet_outlet_number());
            stmt.setInt(3, inventory.getProduct_product_code());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }
}
