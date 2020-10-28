package Views;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Report_View {

    public static void reportSalesOutlet(ResultSet rs) throws SQLException {
        while(rs.next()) {
            System.out.print("\nOutlet number: " + rs.getInt(1));
            System.out.print("\tYear sales: " + rs.getInt(2));
        }
        System.out.println("\n");
    }

    public static void reportSalesEmployee(ResultSet rs) throws SQLException {
        while(rs.next()) {
            System.out.print("\nEmployee number: " + rs.getInt(1));
            System.out.print("\tSales: " + rs.getInt(2));
        }
        System.out.println("\n");
    }

    public static void listTopItems(ResultSet rs) throws SQLException {
        while(rs.next()) {
            System.out.print("\nArtist: " + rs.getString(1));
            System.out.print("\tTitle: " + rs.getString(2));
            System.out.print("\tSale price: " + rs.getDouble(3));
        }
        System.out.println("\n");
    }
}
