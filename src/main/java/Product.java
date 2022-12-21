import java.util.Calendar;
import java.util.GregorianCalendar;

public class Product {
    private String productName;
    private double productPrice;

    public Product(String product, double price) {
        this.productName = product;
        this.productPrice = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

}