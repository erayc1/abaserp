import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemOrderQuantities {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
            new Item(1000, 2000, 12),
            new Item(1000, 2001, 31),
            new Item(1000, 2002, 22),
            new Item(1000, 2003, 41),
            new Item(1000, 2004, 55),
            new Item(1001, 2001, 88),
            new Item(1001, 2002, 121),
            new Item(1001, 2003, 74),
            new Item(1001, 2004, 14),
            new Item(1002, 2001, 31),
            new Item(1002, 2002, 22),
            new Item(1002, 2003, 99),
            new Item(1002, 2004, 19)
        );

        Map<Integer, Map<Integer, Integer>> orderQuantities = items.stream()
            .collect(Collectors.groupingBy(Item::getItemNumber,
                    Collectors.groupingBy(Item::getOrder, Collectors.summingInt(Item::getQuantity))));
        
        orderQuantities.forEach((itemNumber, orders) -> {
            System.out.println("Item number: " + itemNumber);
            orders.forEach((order, quantity) -> 
                System.out.println("  Order: " + order + ", Quantity: " + quantity));
        });
    }
}
