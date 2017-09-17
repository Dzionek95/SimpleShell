package com.dzionek.simpleshell.shellmanaging;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Bartlomiej Janik
 * @since 9/17/2017
 */
@Test
public class ShellDataTest {

    private ShellData shellData;

    @BeforeTest
    public void setUp(){
        shellData = new ShellData();
    }

    public void shouldPopulateMapWithFourCommands(){
        Assert.assertEquals(shellData.getMapOfNonAffectingCommands().size(),4);
    }

    public void shouldPopulateMapWithTwoCommands(){
        Assert.assertEquals(shellData.getMapOfAffectingCommands().size(),2);
    }
}
