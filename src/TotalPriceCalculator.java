import java.util.Arrays;
import java.util.List;

public class TotalPriceCalculator {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item(1000, 2000, 12, 100.51),
            new Item(1000, 2001, 31, 200),
            new Item(1000, 2002, 22, 150.86),
            new Item(1000, 2003, 41, 250),
            new Item(1000, 2004, 55, 44),
            new Item(1001, 2001, 88, 200),
            new Item(1001, 2002, 121, 200),
            new Item(1001, 2003, 74, 44),
            new Item(1001, 2004, 14, 88.11),
            new Item(1002, 2001, 31, 200),
            new Item(1002, 2002, 22, 150.86),
            new Item(1002, 2003, 99, 150),
            new Item(1002, 2004, 19, 50)
        );

        double total = items.stream().mapToDouble(Item::getTotalPrice).sum();
        System.out.println("Total price for all items: " + total);
    }
}
