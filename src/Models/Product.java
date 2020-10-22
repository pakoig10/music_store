package Models;

public class Product {

    private int product_code;
    private String artist;
    private String title;
    private float cost;
    private float sale_price;

    public int getProduct_code() { return product_code; }

    public void setProduct_code(int product_code) { this.product_code = product_code; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public float getCost() { return cost; }

    public void setCost(float cost) { this.cost = cost; }

    public float getSale_price() { return sale_price; }

    public void setSale_price(float sale_price) { this.sale_price = sale_price; }
}
