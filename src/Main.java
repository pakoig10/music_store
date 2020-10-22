import Controllers.*;
import Helpers.DBUtil;
import Helpers.InputHelper;
import Models.Customer;
import Models.Outlet;
import Models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Customer_Controller.createRecord();
        Customer_Controller.modifyById();
        Customer_Controller.deleteById();
        //Outlet_Controller.createRecord();
        //Outlet_Controller.modifyById();
        //Outlet_Controller.deleteById();
        //Product_Controller.createRecord();
        //Product_Controller.modifyById();
        //Product_Controller.deleteById();
        //Employee_Controller.createRecord();
        //Employee_Controller.modifyById();
        //Employee_Controller.deleteById();
        //Sale_Controller.createRecord();
        //Sale_Controller.searchByIdDate();
        //Inventory_Controller.createRecord();
        //Return_Controller.createRecord();
        //Return_Controller.searchByIdDate();
        //Menu_Controller.mainMenu();
    }
}
