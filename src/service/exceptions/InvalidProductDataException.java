package service.exceptions;

public class InvalidProductDataException extends RuntimeException{

    private String message;

    public InvalidProductDataException(String message) {
        super(message);
    }
}
