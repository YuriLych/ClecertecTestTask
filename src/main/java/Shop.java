import java.util.Map;

public class Shop {
    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    private Map<Product,Integer> storeAssortment;
    private Map<DiscountCard,Integer> discountCards;

    public Shop() {
        storeName = "Supermarket 123";
        storeAddress = "12, Milkyway Galaxy/ Earth";
        storePhoneNumber = "123-456-7890";
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public void getCheckHeader() {
        System.out.printf("%37s\n",storeName);
        System.out.printf("%43s\n",storeAddress);
        System.out.printf("%26s%s\n","Tel: ",storePhoneNumber);
    }
}
