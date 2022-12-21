import java.util.*;

public class CheckRunner {

    public static void main(String[] args) {
        Shop shop = new Shop();

        Map<Integer, Product> products = new HashMap<>();
        products.put(1, new Product("Bread Volotovskoy", 1.51));
        products.put(2, new Product("Sugar Litvinsky", 2.64));
        products.put(3, new Product("Milk Brest-Litovskoe 3,5%", 2.06));
        products.put(4, new Product("Butter Krestjanskoe 72%", 3.78));
        products.put(5, new Product("Whiskey LAPHROAIG SELECT", 191.51));

        Map<String, Integer> cards = new HashMap<>();
        cards.put("12345", 15);
        cards.put("3456", 5);
        cards.put("7890", 20);

        Set<Integer> discountActions = new HashSet<>();
        discountActions.add(4);
        discountActions.add(5);

        CheckBuilder newcheck = new CheckBuilder(shop,products,cards,discountActions);
        newcheck.printCheck(shop,args);
    }
}
