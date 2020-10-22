package Views;

import Helpers.InputHelper;
import Models.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer_View {

    public static Customer setObject(Customer customer) {
        customer.setCustomer_name(InputHelper.outputString("Insert your name:"));
        customer.setAddress(InputHelper.outputString("Insert your address:"));
        customer.setCity(InputHelper.outputString("Insert your city:"));
        customer.setState(InputHelper.outputString("Insert your state:"));
        customer.setZip(InputHelper.outputString("Insert your zip(5):"));
        customer.setPhone(InputHelper.outputString("Insert your phone(10):"));
        return customer;
    }

    public static PreparedStatement insertToModify(PreparedStatement stmt, int id, ResultSet rs) throws SQLException {
        stmt.setString(1, InputHelper.outputString(("Insert the new customer name: " + rs.getString(2))));
        stmt.setString(2, InputHelper.outputString(("Insert the new address: " + rs.getString(3))));
        stmt.setString(3, InputHelper.outputString(("Insert the new city: " + rs.getString(4))));
        stmt.setString(4, InputHelper.outputString(("Insert the new state: " + rs.getString(5))));
        stmt.setString(5, InputHelper.outputString(("Insert the new zip: " + rs.getString(6))));
        stmt.setString(6, InputHelper.outputString(("Insert the new phone: " + rs.getString(7))));
        stmt.setInt(7, id);
        return stmt;
    }
}
