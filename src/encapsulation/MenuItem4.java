package encapsulation;

public class MenuItem4 {
    private String name;
    private double price;
    private String contnets;


    public MenuItem4(String name, double price, String contnets) {
        this.name = name;
        this.price = price;
        this.contnets = contnets;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getContnets() {
        return contnets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setContnets(String contnets) {
        this.contnets = contnets;
    }

}
