package dev.buskopan.encurtaa.exceptions.exception;

public class ExpiredUrlException extends RuntimeException {
    public ExpiredUrlException() {
        super("This URL expired");
    }
}
