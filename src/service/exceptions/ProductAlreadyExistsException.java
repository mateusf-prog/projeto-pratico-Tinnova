package service.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {

    private String message;

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
