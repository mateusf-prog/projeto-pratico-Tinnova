package service;

import domain.Product;
import domain.Store;
import service.exceptions.InvalidProducDataException;
import service.exceptions.ProductAlreadyExistsException;

import java.util.List;

public class StoreService {

    private final Store store;

    public StoreService(Store store) {
        this.store = store;
    }

    public Product addProduct(Product product) {

        if (!isValidateProductName(product.getName())) {
            throw new InvalidProducDataException("Nome do produto não pode ser nulo ou vazio");
        }
        if (!isValidProductQuantity(product.getQuantity())) {
            throw new InvalidProducDataException("Quantidade do produto não pode ser nula ou menor que 1");
        }
        if (isProductAlreadyExists(product.getName())) {
            throw new ProductAlreadyExistsException("Produto já existe");
        };

        store.addProduct(product);
        return product;
    }

    public boolean isValidateProductName(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return true;
    }

    public boolean isValidProductQuantity(Integer quantity) {
        if (quantity == null || quantity<= 0) {
            return false;
        }
        return true;
    }

    public boolean isProductAlreadyExists(String name) {
        for (Product product : store.getProducts()) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
