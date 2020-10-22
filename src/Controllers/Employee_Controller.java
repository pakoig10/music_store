package Controllers;

import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Customer;
import Models.Employee;

import java.sql.*;

public class Employee_Controller {

    public static void createRecord() throws SQLException {
        try(Connection conn = DBUtil.getConnection()) {
            Employee employee;
            employee = createObject();
            ResultSet keys;
            String sql = "INSERT INTO employee (emp_name, outlet_outlet_number) VALUES (?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, employee.getEmp_name());
            stmt.setInt(2, employee.getOutlet_outlet_number());
            stmt.executeUpdate();
            System.out.println("Query executed.\n");
            keys = stmt.getGeneratedKeys();
            keys.next();
            employee.setEmp_number(keys.getInt(1));
        } catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }

    public static ResultSet searchById(int id) throws SQLException {
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
            stmt.setString(1, InputHelper.outputString(("Insert the new employee name: " + rs.getString(2))));
            stmt.setInt(2, InputHelper.outputInt(("Insert the new outlet number: " + rs.getString(3))));
            stmt.setInt(3, id);
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

    private static Employee createObject() {
        Employee employee = new Employee();
        employee.setEmp_name(InputHelper.outputString("Insert your employee name: "));
        employee.setOutlet_outlet_number(InputHelper.outputInt("Insert your outlet number: "));
        return employee;
    }
}
