package Views;

import Helpers.InputHelper;
import Models.Outlet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Outlet_View {

    public static Outlet setObject(Outlet outlet) {
        outlet.setAddress(InputHelper.outputString("Insert your address:"));
        outlet.setCity(InputHelper.outputString("Insert your city:"));
        outlet.setState(InputHelper.outputString("Insert your state:"));
        outlet.setZip(InputHelper.outputString("Insert your zip(5):"));
        outlet.setPhone(InputHelper.outputString("Insert your phone(10):"));
        return outlet;
    }

    public static PreparedStatement insertToModify (PreparedStatement stmt, int id, ResultSet rs) throws SQLException {
        stmt.setString(1, InputHelper.outputString(("Insert the new address: " + rs.getString(2))));
        stmt.setString(2, InputHelper.outputString(("Insert the new city: " + rs.getString(3))));
        stmt.setString(3, InputHelper.outputString(("Insert the new state: " + rs.getString(4))));
        stmt.setString(4, InputHelper.outputString(("Insert the new zip: " + rs.getString(5))));
        stmt.setString(5, InputHelper.outputString(("Insert the new phone: " + rs.getString(6))));
        stmt.setInt(6, id);
        return stmt;
    }
}
