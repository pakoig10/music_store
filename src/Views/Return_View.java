package Views;

import Helpers.InputHelper;
import Models.Return;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Return_View {

    public static Return setObject(Return return1) {
        return1.setReason(InputHelper.outputString("Insert the reason: "));
        return1.setSales_sale_id(InputHelper.outputInt("Insert the sales id: "));
        return return1;
    }


    public static void resultSearchByIdDate(ResultSet rs) throws SQLException {
        while(rs.next()){
            System.out.println("Return id: " + rs.getInt(1));
            System.out.println("Return date-time: " + rs.getString(2));
            System.out.println("Reason: " + rs.getString(3));
            System.out.println("Sale id: " + rs.getInt(5));
            System.out.println("Sale date-time: " + rs.getString(6));
            System.out.println("Quantity: " + rs.getInt(7));
            System.out.println("Outlet number: " + rs.getInt(8));
            System.out.println("Product code: " + rs.getInt(9));
            System.out.println("Employee number: " + rs.getInt(10));
            System.out.println("Customer id: " + rs.getInt(11));
        }
    }
}
