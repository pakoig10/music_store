package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Product;

import java.sql.*;

public class Product_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Product product;
            product = createObject();
            ResultSet keys;
            String sql = "INSERT INTO product (artist, title, cost, sale_price) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getArtist());
            stmt.setString(2, product.getTitle());
            stmt.setFloat(3, product.getCost());
            stmt.setFloat(4, product.getSale_price());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
            keys = stmt.getGeneratedKeys();
            keys.next();
            product.setProduct_code(keys.getInt(1));
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static ResultSet searchById(int id) throws SQLException {
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
            stmt.setString(1, InputHelper.outputString(("Insert the new artist: " + rs.getString(2))));
            stmt.setString(2, InputHelper.outputString(("Insert the new title: " + rs.getString(3))));
            stmt.setString(3, InputHelper.outputString(("Insert the new cost: " + rs.getString(4))));
            stmt.setString(4, InputHelper.outputString(("Insert the new sale price: " + rs.getString(5))));
            stmt.setInt(5, id);
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

    private static Product createObject() {
        Product product = new Product();
        product.setArtist(InputHelper.outputString("Insert the artist:"));
        product.setTitle(InputHelper.outputString("Insert the title:"));
        product.setCost(InputHelper.outputFloat("Insert the cost:"));
        product.setSale_price(InputHelper.outputFloat("Insert the sale cost:"));
        return product;
    }
}
