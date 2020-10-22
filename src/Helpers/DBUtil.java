package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String TIME_ZONE_CONF = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB = "music_store";
    private static final String CONN_STRING = "jdbc:mysql://localhost/";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection((CONN_STRING + DB + TIME_ZONE_CONF), USERNAME, PASSWORD);
    }

    public static void processException(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("VendorError: " + e.getErrorCode());
    }
}
