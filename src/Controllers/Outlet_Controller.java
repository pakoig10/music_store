package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Customer;
import Models.Outlet;

import java.sql.*;

public class Outlet_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Outlet outlet;
            outlet = createObject();
            ResultSet keys;
            String sql = "INSERT INTO outlet (address, city, state, zip, phone) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, outlet.getAddress());
            stmt.setString(2, outlet.getCity());
            stmt.setString(3, outlet.getState());
            stmt.setString(4, outlet.getZip());
            stmt.setString(5, outlet.getPhone());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
            keys = stmt.getGeneratedKeys();
            keys.next();
            outlet.setOutlet_number(keys.getInt(1));
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static ResultSet searchById(int id) throws SQLException {
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM outlet WHERE outlet_number = ?;";
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
            int id = InputHelper.outputInt("Insert the outlet number: ");
            ResultSet rs = searchById(id);
            String sql = "UPDATE outlet SET address = ?, city = ?, state = ?, zip = ?, phone = ? WHERE outlet_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, InputHelper.outputString(("Insert the new address: " + rs.getString(2))));
            stmt.setString(2, InputHelper.outputString(("Insert the new city: " + rs.getString(3))));
            stmt.setString(3, InputHelper.outputString(("Insert the new state: " + rs.getString(4))));
            stmt.setString(4, InputHelper.outputString(("Insert the new zip: " + rs.getString(5))));
            stmt.setString(5, InputHelper.outputString(("Insert the new phone: " + rs.getString(6))));
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    public static void deleteById() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            int id = InputHelper.outputInt("Insert the outlet number: ");
            String sql = "DELETE FROM outlet WHERE outlet_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    private static Outlet createObject() {
        Outlet outlet = new Outlet();
        outlet.setAddress(InputHelper.outputString("Insert your address:"));
        outlet.setCity(InputHelper.outputString("Insert your city:"));
        outlet.setState(InputHelper.outputString("Insert your state:"));
        outlet.setZip(InputHelper.outputString("Insert your zip(5):"));
        outlet.setPhone(InputHelper.outputString("Insert your phone(10):"));
        return outlet;
    }
}
