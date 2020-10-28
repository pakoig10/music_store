package Views;

import Helpers.InputHelper;
import Models.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_View {

    public static Employee setObject(Employee employee) {
        employee.setEmp_name(InputHelper.outputString("Insert your employee name: "));
        employee.setOutlet_outlet_number(InputHelper.outputInt("Insert your outlet number: "));
        return employee;
    }

    public static PreparedStatement insertToModify(PreparedStatement stmt, int id, ResultSet rs) throws SQLException {
        stmt.setString(1, InputHelper.outputString(("Insert the new employee name: " + rs.getString(2))));
        stmt.setInt(2, InputHelper.outputInt(("Insert the new outlet number: " + rs.getString(3))));
        stmt.setInt(3, id);
        return stmt;
    }
}
