import java.util.*;

public class CheckBuilder {
    String checkHeader;
    GregorianCalendar checkDateAndTime;
    Random numOfCheck;

    Shop shop;

    Map<Integer, Product> products;

    Map<String, Integer> cards;

    Set<Integer> discountActions;



    CheckBuilder(Shop shop, Map<Integer, Product> products, Map<String, Integer> cards, Set<Integer> discountActions) {
        this.checkHeader = "CASH RECEIPT";
        this.checkDateAndTime = new GregorianCalendar();
        this.numOfCheck = new Random();
        this.shop = shop;
        this.products = products;
        this.cards = cards;
        this.discountActions = discountActions;
    }

    public void printCheckHead() {
        System.out.printf("%35s\n",checkHeader);
    }

    public void printCheckDateAndTime() {
        System.out.printf("CASHIER: %s%d %24s%-2d/%-2d/%-4d\n",
                "N", Integer.toUnsignedLong(numOfCheck.nextInt()),
                "DATE: ",
                checkDateAndTime.get(Calendar.DAY_OF_MONTH),
                (checkDateAndTime.get(Calendar.MONTH) + 1),
                checkDateAndTime.get(Calendar.YEAR));
        System.out.printf("%45s%-2d:%-2d:%-4d\n","TIME: ",
                checkDateAndTime.get(Calendar.HOUR_OF_DAY),
                checkDateAndTime.get(Calendar.MINUTE),
                checkDateAndTime.get(Calendar.SECOND));
        System.out.printf("%-5s%-36s%-9s%-9s\n","QTY","DESCRIPTION","PRICE","TOTAL");
    }
    public void PrintFooterOfCheck(int discount,double check,int actions) {
        final String taxTotal = "TAXABLE TOTAL";
        final String vat = "VAT";
        final String total = "TOTAL";
        System.out.println(String.format("%55s", "").replace(' ', '-'));
        System.out.printf("%-13s%42.2f\n",taxTotal,
                (check - check * discount / 100));
        System.out.printf("%-3s%9d%%%42.2f  \n",vat,
                discount, (check * discount / 100));
        System.out.printf("%-13s%42.2f\n",total, check);
        System.out.println(String.format("%55s", "").replace(' ', '-'));
        if (actions > 0) {
            System.out.println("* - promotional product, quantity > 5, discount 10%");
            System.out.println(String.format("%55s", "").replace(' ', '-'));
        }
    }

    public void printBreakLine() {
        System.out.println(String.format("%55s", "").replace(' ', '-'));
    }

    public void printLineOfCheck(String actproduct,int quantProduct,String nameProduct,double price,double sum) {
        System.out.printf("%-1s%-4d%-34s%7.2f%9.2f \n",
                actproduct, quantProduct, nameProduct, price, sum);
    }
    public void printFooterOfCheck(int discount,double check,int actions) {
        final String taxTotal = "TAXABLE TOTAL";
        final String vat = "VAT";
        final String total = "TOTAL";
        System.out.println(String.format("%55s", "").replace(' ', '-'));
        System.out.printf("%-13s%42.2f\n",taxTotal,
                (check - check * discount / 100));
        System.out.printf("%-3s%9d%%%42.2f  \n",vat,
                discount, (check * discount / 100));
        System.out.printf("%-13s%42.2f\n",total, check);
        System.out.println(String.format("%55s", "").replace(' ', '-'));
        if (actions > 0) {
            System.out.println("* - promotional product, quantity > 5, discount 10%");
            System.out.println(String.format("%55s", "").replace(' ', '-'));
        }
    }
    public void printCheck(Shop shop,String[] args) {

        int discountTotal = 0;
        double checkTotal = 0;
        int actionProducts = 0;

        printCheckHead();
        shop.getCheckHeader();
        printCheckDateAndTime();
        printBreakLine();


        for (String arg : args) {
            int discountProduct = 0;
            String actionProduct = "";
            if (arg.toLowerCase().contains("card")) {
                String codeOfCard = arg.substring(arg.indexOf("-") + 1);
                discountTotal = cards.get(codeOfCard);
                continue;
            }
            try {
                int codeOfProduct = Integer.parseInt(arg.substring(0, arg.indexOf("-")));
                int quantityOfProduct = Integer.parseInt(arg.substring(arg.indexOf("-") + 1));
                String nameOfProduct = products.get(codeOfProduct).getProductName();
                double priceOfProduct = products.get(codeOfProduct).getProductPrice();
                double sumProduct = products.get(codeOfProduct).getProductPrice() * quantityOfProduct;
                boolean cont = discountActions.contains(codeOfProduct);
                if (quantityOfProduct > 5 && discountActions.contains(codeOfProduct)) {
                    discountProduct = 10;
                    actionProduct = "*";
                    actionProducts++;
                }
                sumProduct = sumProduct - (sumProduct / 100 * discountProduct);

        printLineOfCheck(actionProduct, quantityOfProduct, nameOfProduct, priceOfProduct, sumProduct);

                checkTotal += sumProduct;
            } catch (NullPointerException e) {
            }
        };

        printFooterOfCheck(discountTotal, checkTotal, actionProducts);

    }
}
