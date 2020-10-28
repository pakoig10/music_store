package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Outlet;
import Views.Outlet_View;

import java.sql.*;

public class Outlet_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Outlet outlet = new Outlet();
            outlet = Outlet_View.setObject(outlet);
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

    private static ResultSet searchById(int id) throws SQLException {
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
            stmt = Outlet_View.insertToModify(stmt, id, rs);
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
}
