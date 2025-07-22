package challenge;

public class MenuItem5 {
    private static String name;
    private double price;
    private String contents;

    public MenuItem5(String name, double price, String contents) {
        this.name = name;
        this.price = price;
        this.contents = contents;
    }

    public static String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + contents;
    }

}
