package com.dzionek.simpleshell.user;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Bartlomiej Janik
 * @since 9/17/2017
 */
public class UserInputTest {

    @Test
    public void shoudReturnArrayWithLengthTwo(){
        UserInput userInput = new UserInput();
        userInput.setUserInput("prompt $cwd");
        Assert.assertEquals(userInput.getUserInput().length,2);
    }

}
