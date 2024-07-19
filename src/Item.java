public class Item {
    int order;
    int itemNumber;
    int quantity;
    double unitPrice;

    // Dört argümanlı kurucu
    public Item(int order, int itemNumber, int quantity, double unitPrice) {
        this.order = order;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Üç argümanlı kurucu
    public Item(int order, int itemNumber, int quantity) {
        this.order = order;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.unitPrice = 0; 
    }
    
    public int getOrder() {
        return order;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
    public double getTotalPrice() {
        return quantity * unitPrice;
    }
}


