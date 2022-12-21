public class DiscountCard {
    int idDiscountCard;
    int discountAmount;

    DiscountCard(int idDiscountCard,int discountAmount) {
        this.idDiscountCard = idDiscountCard;
        this.discountAmount = discountAmount;
    }

    public int getIdDiscountCard() { return idDiscountCard; }

    public int getDiscountAmount() { return discountAmount; }

    public void setIdDiscountCard(int idDiscountCard) { this.idDiscountCard = idDiscountCard; }

    public void setDiscountAmount(int discountAmount) { this.discountAmount = discountAmount; }

    @Override
    public String toString() { return "Discount Card:" + this.idDiscountCard; }
}

