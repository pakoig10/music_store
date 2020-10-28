package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Return;
import Models.Sale;
import Views.Return_View;

import java.sql.*;

public class Return_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Return return1 = new Return();
            return1 = Return_View.setObject(return1);
            String sql = "INSERT INTO returns (reason, sales_sale_id) VALUES (?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, return1.getReason());
            stmt.setInt(2, return1.getSales_sale_id());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static void searchByIdDate() throws SQLException {
        try {
            int id = InputHelper.outputInt("Insert the return id: ");
            String date = InputHelper.outputString("Insert the date (yyyy-MM-dd): ");
            String time = InputHelper.outputString("Insert the time (HH:mm:ss): ");
            String dateTime = date + " " + time;
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM returns AS r JOIN sales AS s ON r.sales_sale_id = s.sale_id WHERE r.return_id = ? AND r.return_date_time = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, id);
            stmt.setString(2, dateTime);
            ResultSet rs = stmt.executeQuery();
            Return_View.resultSearchByIdDate(rs);
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }
}
