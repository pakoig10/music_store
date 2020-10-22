package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Customer;
import Views.Customer_View;

import java.sql.*;

public class Customer_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Customer customer;
            customer = createObject();
            ResultSet keys;
            String sql = "INSERT INTO customer (customer_name, address, city, state, zip, phone) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, customer.getCustomer_name());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getCity());
            stmt.setString(4, customer.getState());
            stmt.setString(5, customer.getZip());
            stmt.setString(6, customer.getPhone());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
            keys = stmt.getGeneratedKeys();
            keys.next();
            customer.setCustomer_id(keys.getInt(1));
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static ResultSet searchById(int id) throws SQLException {
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM customer WHERE customer_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs;
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
        return null;
    }

    public static void modifyById() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            int id = InputHelper.outputInt("Insert the customer id: ");
            ResultSet rs = searchById(id);
            String sql = "UPDATE customer SET customer_name = ?, address = ?, city = ?, state = ?, zip = ?, phone = ? WHERE customer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = Customer_View.insertToModify(stmt, id, rs);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    public static void deleteById() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            int id = InputHelper.outputInt("Insert the customer id: ");
            String sql = "DELETE FROM customer WHERE customer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    private static Customer createObject() {
        Customer customer = new Customer();
        Customer_View.setObject(customer);
        return customer;
    }
}
