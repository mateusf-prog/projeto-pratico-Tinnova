package service.exceptions;

public class InvalidProducDataException extends RuntimeException{

    private String message;

    public InvalidProducDataException(String message) {
        super(message);
    }
}
