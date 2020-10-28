package Controllers;

import Helpers.DBUtil;
import Views.Report_View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Report_Controller {

    public static void salesReportForOutlet() {
        try(Connection conn = DBUtil.getConnection()){
            String sql = "SELECT s.outlet_outlet_number, SUM(p.sale_price) AS 'Year_Sales'\n" +
                        "FROM sales AS s\n" +
                        "JOIN product AS p ON p.product_code = s.product_product_code\n" +
                        "WHERE (s.sale_date_time BETWEEN '2020-01-01 00:00:01' AND '2020-12-31 23:59:59')\n" +
                        "GROUP BY s.outlet_outlet_number";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Query executed");
            Report_View.reportSalesOutlet(rs);
        }
        catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

    public static void salesReportForEmployee() {
        try(Connection conn = DBUtil.getConnection()){
            String sql = "SELECT s.employee_emp_number, SUM(p.sale_price) AS 'Sales'\n" +
                    "FROM sales AS s\n" +
                    "JOIN product AS p ON p.product_code = s.product_product_code\n" +
                    "JOIN employee AS e ON e.emp_number = s.employee_emp_number\n" +
                    "GROUP BY s.employee_emp_number";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Query executed");
            Report_View.reportSalesEmployee(rs);
        }
        catch (SQLException e) {
            DBUtil.processException(e);
        }
    }

    public static void listTopSellingItems(int limit) {
        try(Connection conn = DBUtil.getConnection()){
            String sql = "SELECT p.artist, p.title, p.sale_price\n" +
                    "FROM sales AS s\n" +
                    "INNER JOIN product AS p ON p.product_code = s.product_product_code\n" +
                    "GROUP BY s.product_product_code\n" +
                    "ORDER BY p.sale_price DESC\n" +
                    "LIMIT ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Query executed");
            Report_View.listTopItems(rs);
        }
        catch (SQLException e) {
            DBUtil.processException(e);
        }
    }
}
