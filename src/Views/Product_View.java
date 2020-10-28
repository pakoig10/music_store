package Views;

import Helpers.InputHelper;
import Models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product_View {

    public static Product setObject(Product product) {
        product.setArtist(InputHelper.outputString("Insert the artist:"));
        product.setTitle(InputHelper.outputString("Insert the title:"));
        product.setCost(InputHelper.outputFloat("Insert the cost:"));
        product.setSale_price(InputHelper.outputFloat("Insert the sale cost:"));
        return product;
    }

    public static PreparedStatement insertToModify(PreparedStatement stmt, int id, ResultSet rs) throws SQLException {
        stmt.setString(1, InputHelper.outputString(("Insert the new artist: " + rs.getString(2))));
        stmt.setString(2, InputHelper.outputString(("Insert the new title: " + rs.getString(3))));
        stmt.setString(3, InputHelper.outputString(("Insert the new cost: " + rs.getString(4))));
        stmt.setString(4, InputHelper.outputString(("Insert the new sale price: " + rs.getString(5))));
        stmt.setInt(5, id);
        return stmt;
    }
}
