package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Employee;
import Models.Sale;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Sale sale;
            sale = createObject();
            String sql = "INSERT INTO sales (quantity, outlet_outlet_number, product_product_code, employee_emp_number, customer_customer_id) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, sale.getQuantity());
            stmt.setInt(2, sale.getOutlet_outlet_number());
            stmt.setInt(3, sale.getProduct_product_code());
            stmt.setInt(4, sale.getEmployee_emp_number());
            stmt.setInt(5, sale.getCustomer_customer_id());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static void searchByIdDate() throws SQLException {
        try {
            int id = InputHelper.outputInt("Insert the sale id: ");
            String date = InputHelper.outputString("Insert the date (yyyy-MM-dd): ");
            String time = InputHelper.outputString("Insert the time(HH:mm:ss): ");
            String dateTime = date + " " + time;
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM sales WHERE sale_id = ? AND sale_date_time = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, id);
            stmt.setString(2, dateTime);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                System.out.println("Sale id: " + rs.getInt(1));
                System.out.println("Sale date-time: " + rs.getString(2));
                System.out.println("Quantity: " + rs.getInt(3));
                System.out.println("Outlet number: " + rs.getInt(4));
                System.out.println("Product code: " + rs.getInt(5));
                System.out.println("Employee number: " + rs.getInt(6));
                System.out.println("Customer id: " + rs.getInt(7));
            }
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    private static Sale createObject() {
        Sale sale = new Sale();
        sale.setQuantity(InputHelper.outputInt("Insert the quantity: "));
        sale.setOutlet_outlet_number(InputHelper.outputInt("Insert your outlet number: "));
        sale.setProduct_product_code(InputHelper.outputInt("Insert the product code: "));
        sale.setEmployee_emp_number(InputHelper.outputInt("Insert the employee number: "));
        sale.setCustomer_customer_id(InputHelper.outputInt("Insert the customer id: "));
        return sale;
    }
}
