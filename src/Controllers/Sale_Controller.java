package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Sale;
import Views.Sale_View;

import java.sql.*;

public class Sale_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Sale sale = new Sale();
            sale = Sale_View.setObject(sale);
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
            Sale_View.resultSearchByIdDate(rs);
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }
}
