package com.manto9.exceptions;

/**
 * Created by manto9 on 19/02/16.
 */
public class NumberFormatException extends Exception {
    public NumberFormatException() {
        super();
    }

    public NumberFormatException(String message){
        super(message);
    }

    public NumberFormatException(String message, Throwable cause){
        super(message,cause);
    }

    public NumberFormatException(Throwable cause){
        super(cause);
    }

}
