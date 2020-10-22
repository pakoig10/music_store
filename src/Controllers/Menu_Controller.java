package Controllers;

import Views.Menu_View;

import java.util.Scanner;

public class Menu_Controller {

    public static void mainMenu() {
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

    private static void saleReturnMenu() {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        Menu_View.saleReturnMenu();
        while(answer != 5) {
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 5: break;
            }
        }
    }

    private static void maintenanceMenu() {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        Menu_View.maintenanceMenu();
        while(answer != 7) {
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 7: break;
            }
        }
    }

    private static void reportsMenu() {
        int answer = 0;
        Scanner scan = new Scanner(System.in);
        Menu_View.reportsMenu();
        while(answer != 4) {
            System.out.print("Insert the option: ");
            answer = scan.nextInt();
            switch (answer){
                case 4: break;
            }
        }
    }
}
