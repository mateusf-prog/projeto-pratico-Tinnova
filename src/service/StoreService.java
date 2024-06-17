package service;

import domain.Product;
import domain.Store;
import service.exceptions.EmptyListException;
import service.exceptions.InvalidProducDataException;
import service.exceptions.ProductAlreadyExistsException;
import service.exceptions.ProductNotFoundException;

import java.util.List;

public class StoreService {

    private final Store store;

    public StoreService(Store store) {
        this.store = store;
    }

    public void addProduct(Product product) {

        if (isValidateProductName(product.getName())) {
            throw new InvalidProducDataException("Nome do produto não pode ser nulo ou vazio");
        }
        if (!isValidProductQuantity(product.getQuantity())) {
            throw new InvalidProducDataException("Quantidade do produto não pode ser nula ou menor que 1");
        }
        if (isProductAlreadyExists(product.getName())) {
            throw new ProductAlreadyExistsException("Produto já existe");
        };

        store.addProduct(product);
    }

    public void removeProductByName(String name) {

        if (isListEmpty()) {
            throw new EmptyListException("Lista de produtos vazia");
        }
        if (isValidateProductName(name)) {
            throw new InvalidProducDataException("Nome do produto não pode ser nulo ou vazio");
        }

        Product productToRemove = null;
        for (Product product : store.getProducts()) {
            if (product.getName().equals(name)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            store.getProducts().remove(productToRemove);
            System.out.println("Produto removido com sucesso!");
        } else {
            throw new ProductNotFoundException("Produto não encontrado");
        }
    }

    public List<Product> getProducts() {
        if (isListEmpty()) {
            throw new EmptyListException("Lista de produtos vazia");
        }
        return store.getProducts();
    }

    public Product getProductByName(String name) {

        if (isValidateProductName(name)) {
            throw new InvalidProducDataException("Nome do produto não pode ser nulo ou vazio");
        }
        if (isListEmpty()) {
            throw new EmptyListException("Lista de produtos vazia");
        }

        Product productFound = null;
        for (Product product : store.getProducts()) {
            if (product.getName().equals(name)) {
                productFound = product;
            }
        }
        if (productFound != null) {
            return productFound;
        }
        return null;
    }

    public boolean isValidateProductName(String name) {
        return name == null || name.isBlank();
    }

    public boolean isValidProductQuantity(Integer quantity) {
        return quantity != null && quantity > 0;
    }

    public boolean isProductAlreadyExists(String name) {
        for (Product product : store.getProducts()) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isListEmpty() {
        return store.getProducts().isEmpty();
    }
}
