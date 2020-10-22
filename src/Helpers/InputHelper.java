package Helpers;

import java.util.Scanner;

public class InputHelper {

    public static String outputString(String text){
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        return scan.next();
    }

    public static int outputInt(String text){
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        return scan.nextInt();
    }

    public static float outputFloat(String text){
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        return scan.nextFloat();
    }
}
