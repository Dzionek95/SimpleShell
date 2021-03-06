package com.dzionek.simpleshell.commands.affecting;

import com.dzionek.simpleshell.commands.Commands;
import com.dzionek.simpleshell.commands.CommandPickerFacory;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class AffectingCommandsFactory implements CommandPickerFacory<SetterCommand> {

    @Override
    public SetterCommand pickProperCommand(ShellData shellData, Commands command) {
        return shellData.getMapOfAffectingCommands().get(command);
    }

}
