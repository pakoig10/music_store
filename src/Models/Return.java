package Models;

import java.sql.Date;

public class Return {

    private int return_id;
    private Date return_data_time;
    private String reason;
    private int sales_sale_id;

    public int getReturn_id() {
        return return_id;
    }

    public void setReturn_id(int return_id) {
        this.return_id = return_id;
    }

    public Date getReturn_data_time() {
        return return_data_time;
    }

    public void setReturn_data_time(Date return_data_time) {
        this.return_data_time = return_data_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getSales_sale_id() {
        return sales_sale_id;
    }

    public void setSales_sale_id(int sales_sale_id) {
        this.sales_sale_id = sales_sale_id;
    }
}
