package errors;

public class InsufficientPiecesException extends IllegalArgumentException {
    public  InsufficientPiecesException(String message){
        super(message);
    }
}
