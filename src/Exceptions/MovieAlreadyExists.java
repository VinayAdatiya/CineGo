package Exceptions;

public class MovieAlreadyExists extends Exception{
    public MovieAlreadyExists(String message) {
        super(message);
    }
}
