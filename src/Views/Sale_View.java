package Views;

import Helpers.InputHelper;
import Models.Sale;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sale_View {

    public static Sale setObject(Sale sale) {
        sale.setQuantity(InputHelper.outputInt("Insert the quantity: "));
        sale.setOutlet_outlet_number(InputHelper.outputInt("Insert your outlet number: "));
        sale.setProduct_product_code(InputHelper.outputInt("Insert the product code: "));
        sale.setEmployee_emp_number(InputHelper.outputInt("Insert the employee number: "));
        sale.setCustomer_customer_id(InputHelper.outputInt("Insert the customer id: "));
        return sale;
    }

    public static void resultSearchByIdDate(ResultSet rs) throws SQLException {
        while(rs.next()){
            System.out.println("Sale id: " + rs.getInt(1));
            System.out.println("Sale date-time: " + rs.getString(2));
            System.out.println("Quantity: " + rs.getInt(3));
            System.out.println("Outlet number: " + rs.getInt(4));
            System.out.println("Product code: " + rs.getInt(5));
            System.out.println("Employee number: " + rs.getInt(6));
            System.out.println("Customer id: " + rs.getInt(7));
        }
    }
}
