package com.myretail.exception;

/**
 * This exception is thrown when the requested entry is not found.
 * @author jayakrishnan.s
 */
public class MyRetailException extends RuntimeException {

    public MyRetailException(String id) {
        super(String.format("No entry found with id: <%s>", id));
    }
}
