package com.dzionek.simpleshell.commands;

import com.dzionek.simpleshell.shellmanaging.ShellData;
import com.dzionek.simpleshell.shellmanaging.ShellMechanism;
import com.dzionek.simpleshell.user.UserInput;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * @author Bartlomiej Janik
 * @since 9/17/2017
 */
@Test
public class PromptCommandTest {

    public void shoudChangePromptSignToAkuku(){
        //given
        UserInput userInput = mock(UserInput.class);
        ShellData shellData = new ShellData();
        ShellMechanism shellMechanism = new ShellMechanism(shellData,userInput);

        //when
        when(userInput.getUserInput()).thenReturn(new String[]{"prompt","akuku"});

        //then
        shellMechanism.executeCommandAccordingToUserInput();
        Assert.assertEquals(shellData.getPromptSign(),"[MyShell] akuku $> ");
    }

    public void shouldChangePromptSignToCurrentPath(){
        //given
        UserInput userInput = mock(UserInput.class);
        ShellData shellData = spy(ShellData.class);
        ShellMechanism shellMechanism = new ShellMechanism(shellData,userInput);

        //when
        when(shellData.getCurrentDirectory()).thenReturn("C:/Bartek/Jest/Super");
        when(userInput.getUserInput()).thenReturn(new String[]{"prompt","$cwd"});

        shellMechanism.executeCommandAccordingToUserInput();
        Assert.assertEquals(shellData.getPromptSign(),"[MyShell] C:/Bartek/Jest/Super $> ");
    }

    public void shoudResetPromptToDefaultValue(){
        //given
        UserInput userInput = mock(UserInput.class);
        ShellData shellData = new ShellData();
        ShellMechanism shellMechanism = new ShellMechanism(shellData,userInput);
        //when
        when(userInput.getUserInput()).thenReturn(new String[]{"prompt","reset"});
        shellData.setPromptSign("C:/Bartek/Jest/Super");
        //then
        shellMechanism.executeCommandAccordingToUserInput();
        Assert.assertEquals(shellData.getPromptSign(),"[MyShell]  $> ");
    }
}
