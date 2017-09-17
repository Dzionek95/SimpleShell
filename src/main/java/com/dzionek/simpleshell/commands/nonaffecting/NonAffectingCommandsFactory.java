package com.dzionek.simpleshell.commands.nonaffecting;

import com.dzionek.simpleshell.commands.Commands;
import com.dzionek.simpleshell.commands.Factory;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class NonAffectingCommandsFactory implements Factory<BehaviorCommand> {

    @Override
    public BehaviorCommand pickProperCommand(ShellData shellData, Commands command) {
        return shellData.getMapOfNonAffectingCommands().get(command);
    }

}
