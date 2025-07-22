package challenge;

public class CarItem {
    private MenuItem5 item;
    private int quantity;

    public CarItem(MenuItem5 items) {
        this.item = item;
        this.quantity = 1;
    }

    public void increasequantity() {
        quantity++;
    }

    public MenuItem5 getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return item.getName() + " | W " + item.getPrice() + " | 수량: " + quantity;
    }

}
