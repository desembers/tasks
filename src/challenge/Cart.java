package challenge;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CarItem> items = new ArrayList<>();

    public void addItems(MenuItem5 menuItem5) {
        for (CarItem caritem : items) {
            if (caritem.getItem().getName().equals(MenuItem5.getName())) {
                caritem.increasequantity();
                return;
            }
        }
        items.add(new CarItem(menuItem5));
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
         items.clear();
    }

    public double getTotalPrice() {
        double total = 0;
        for (CarItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void printCart() {
        System.out.println("[Orders ]");
        for (CarItem item : items) {
            System.out.println(item);
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.2f\n", getTotalPrice());
    }
}
