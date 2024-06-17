package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private String name;
    private List<Product> products = new ArrayList<>();

    public Store() {
    }

    public Store(String name) {
        this.name = name;
    }

    public Store(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store: ").append(name).append("\n");
        sb.append("Products: ").append("\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }
}
