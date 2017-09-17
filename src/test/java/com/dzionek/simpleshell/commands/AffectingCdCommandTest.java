package com.dzionek.simpleshell.commands;

import com.dzionek.simpleshell.commands.affecting.SetterCommand;
import com.dzionek.simpleshell.commands.affecting.impl.CdCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;
import com.dzionek.simpleshell.shellmanaging.ShellMechanism;
import com.dzionek.simpleshell.user.UserInput;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @author Bartlomiej Janik
 * @since 9/17/2017
 */
@Test
public class AffectingCdCommandTest {

    public void shoudExecuteExecuteSetterOnce(){
        //given
        CdCommand cdCommand = spy(CdCommand.class);
        ShellData shellData = spy(ShellData.class);
        UserInput userInput = mock(UserInput.class);
        Map<Commands, SetterCommand> mapOfAffectingCommands = new EnumMap<>(Commands.class);
        mapOfAffectingCommands.put(Commands.cd,cdCommand);
        ShellMechanism shellMechanism = new ShellMechanism(shellData,userInput);

        //when
        when(shellData.getMapOfAffectingCommands()).thenReturn(mapOfAffectingCommands);
        when(userInput.getUserInput()).thenReturn(new String[]{"cd",".."});

        //then
        shellMechanism.executeCommandAccordingToUserInput();
        verify(cdCommand,times(1)).executeSetter(any(),any());
    }

}
