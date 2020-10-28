package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Employee;
import Views.Employee_View;

import java.sql.*;

public class Employee_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Employee employee = new Employee();
            Employee_View.setObject(employee);
            String sql = "INSERT INTO employee (emp_name, outlet_outlet_number) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, employee.getEmp_name());
            stmt.setInt(2, employee.getOutlet_outlet_number());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    private static ResultSet searchById(int id) throws SQLException {
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "SELECT * FROM employee WHERE emp_number = ?;";
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
            int id = InputHelper.outputInt("Insert the employee number: ");
            ResultSet rs = searchById(id);
            String sql = "UPDATE employee SET emp_name = ?, outlet_outlet_number = ? WHERE emp_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = Employee_View.insertToModify(stmt, id, rs);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }

    public static void deleteById() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            int id = InputHelper.outputInt("Insert employee number: ");
            String sql = "DELETE FROM employee WHERE emp_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Query executed");
        }catch (SQLException ex){
            DBUtil.processException(ex);
        }
    }
}
