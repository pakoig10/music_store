package Controllers;

import Views.Menu_View;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu_Controller {

    public static void mainMenu() throws SQLException {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        while(answer != 4) {
            Menu_View.mainMenu();
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 1: saleReturnMenu(); break;
                case 2: maintenanceMenu(); break;
                case 3: reportsMenu(); break;
                case 4: System.out.println("Bye bye"); break;
            }
        }
    }

    private static void saleReturnMenu() throws SQLException {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        Menu_View.saleReturnMenu();
        while(answer != 5) {
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 1: Sale_Controller.createRecord(); break;
                case 2: Return_Controller.createRecord(); break;
                case 3: Sale_Controller.searchByIdDate(); break;
                case 4: Return_Controller.searchByIdDate();break;
            }
        }
    }

    private static void maintenanceMenu() throws SQLException {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        while(answer != 7) {
            Menu_View.maintenanceMenu();
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 1: crudMenu("Outlet");break;
                case 2: crudMenu("Employee"); break;
                case 3: crudMenu("Customer"); break;
                case 4: crudMenu("Product"); break;
                case 5: Inventory_Controller.createRecord(); break;
            }
        }
    }

    private static void crudMenu(String object) throws SQLException {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + (object).toUpperCase() + " MENU");
        while(answer != 4) {
            Menu_View.crudMenu();
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 1: case 2: case 3: answer = evaluateAnswerCrud(answer, object); break;
            }
        }
    }

    private static int evaluateAnswerCrud(int answer, String object) throws SQLException {
        switch (object) {
            case "Outlet":
                switch (answer){
                    case 1: Outlet_Controller.createRecord(); break;
                    case 2: Outlet_Controller.modifyById(); break;
                    case 3: Outlet_Controller.deleteById(); break;
                } break;
            case "Employee":
                switch (answer){
                    case 1: Employee_Controller.createRecord(); break;
                    case 2: Employee_Controller.modifyById(); break;
                    case 3: Employee_Controller.deleteById(); break;
                } break;
            case "Customer":
                switch (answer){
                    case 1: Customer_Controller.createRecord(); break;
                    case 2: Customer_Controller.modifyById(); break;
                    case 3: Customer_Controller.deleteById(); break;
                } break;
            case "Product":
                switch (answer){
                    case 1: Product_Controller.createRecord(); break;
                    case 2: Product_Controller.modifyById(); break;
                    case 3: Product_Controller.deleteById(); break;
                } break;
        }
        return 4;
    }

    private static void reportsMenu() {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        while(answer != 4) {
            Menu_View.reportsMenu();
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 1: Report_Controller.salesReportForOutlet();break;
                case 2: Report_Controller.salesReportForEmployee();break;
                case 3: Report_Controller.listTopSellingItems(10);break;
            }
        }
    }
}
