package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Product;
import Views.Product_View;

import java.sql.*;

public class Product_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Product product = new Product();
            product = Product_View.setObject(product);
            String sql = "INSERT INTO product (artist, title, cost, sale_price) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getArtist());
            stmt.setString(2, product.getTitle());
            stmt.setFloat(3, product.getCost());
            stmt.setFloat(4, product.getSale_price());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    private static ResultSet searchById(int id) throws SQLException {
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM product WHERE product_code = ?;";
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
            int id = InputHelper.outputInt("Insert the product code: ");
            ResultSet rs = searchById(id);
            String sql = "UPDATE product SET artist = ?, title = ?, cost = ?, sale_cost = ? WHERE product_code = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = Product_View.insertToModify(stmt, id, rs);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    public static void deleteById() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            int id = InputHelper.outputInt("Insert the product code: ");
            String sql = "DELETE FROM product WHERE product_code = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }
}
