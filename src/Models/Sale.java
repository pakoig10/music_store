package Models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Sale {

    private int sale_id;
    private Date sale_date_time;
    private int quantity;
    private int outlet_outlet_number;
    private int product_product_code;
    private int employee_emp_number;
    private int customer_customer_id;

    public int getSale_id() {
        return sale_id;
    }

    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    public Date getSale_date_time() {
        return sale_date_time;
    }

    public void setSale_date_time(Date sale_date_time) {
        this.sale_date_time = sale_date_time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOutlet_outlet_number() {
        return outlet_outlet_number;
    }

    public void setOutlet_outlet_number(int outlet_outlet_number) {
        this.outlet_outlet_number = outlet_outlet_number;
    }

    public int getProduct_product_code() {
        return product_product_code;
    }

    public void setProduct_product_code(int product_product_code) {
        this.product_product_code = product_product_code;
    }

    public int getEmployee_emp_number() {
        return employee_emp_number;
    }

    public void setEmployee_emp_number(int employee_emp_number) {
        this.employee_emp_number = employee_emp_number;
    }

    public int getCustomer_customer_id() {
        return customer_customer_id;
    }

    public void setCustomer_customer_id(int customer_customer_id) {
        this.customer_customer_id = customer_customer_id;
    }
}
