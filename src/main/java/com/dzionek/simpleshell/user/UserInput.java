package com.dzionek.simpleshell.user;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class UserInput {

    private String[] userInput;

    public void setUserInput(String userInput) {
        this.userInput = userInput.split(" ");
    }

    public String[] getUserInput() {
        return userInput;
    }
}
