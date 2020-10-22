package Views;

public class Menu_View {

    public static void mainMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("1. Sale/return processing");
        System.out.println("2. Outlet/employee/customer/product maintenance");
        System.out.println("3. Reports");
        System.out.println("4. Quit");
    }

    public static void saleReturnMenu() {
        System.out.println("\nSALES/RETURNS MENU");
        System.out.println("1. Process a sale");
        System.out.println("2. Process a return");
        System.out.println("3. View a sale (date and customer id needed)");
        System.out.println("4. View a return (date and customer id needed)");
        System.out.println("5. Quit");
    }

    public static void maintenanceMenu() {
        System.out.println("\nMAINTENANCE MENU");
        System.out.println("1. Add/modify/drop outlet");
        System.out.println("2. Add/modify/drop employee");
        System.out.println("3. Add/modify/drop customer");
        System.out.println("4. Add/modify/drop product");
        System.out.println("5. Process new shipment of products for an outlet");
        System.out.println("6. Process returns");
        System.out.println("7. Quit");
    }

    public static void reportsMenu() {
        System.out.println("\nREPORTS MENU");
        System.out.println("1. Produce yearly sales report for outlet");
        System.out.println("2. Produce sales report for employee");
        System.out.println("3. Produce the list of the top 10 selling items");
        System.out.println("4. Quit");
    }
}
