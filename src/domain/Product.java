package domain;

public class Product {

    private String name;
    private Integer quantity;

    public Product() {
    }

    public Product(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "-- Produto -- " +
                "\nNome: " + name +
                "\nQuantidade: " + quantity;
    }
}
