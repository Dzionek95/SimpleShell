package com.dzionek.simpleshell.commands;

/**
 * @author Bartlomiej Janik
 * @since 9/17/2017
 */
public class WrongParametersException extends RuntimeException {

    public WrongParametersException(String message) {
        super(message);
    }

}
