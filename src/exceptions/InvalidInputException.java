package exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String str){
        super();
        System.err.println(str);
    }
}
