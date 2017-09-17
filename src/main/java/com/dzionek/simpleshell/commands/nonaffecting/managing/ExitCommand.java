package com.dzionek.simpleshell.commands.nonaffecting.managing;

import com.dzionek.simpleshell.commands.nonaffecting.BehaviorCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class ExitCommand implements BehaviorCommand {


    public void executeBehavior(ShellData shellData) {
        shellData.setRunning(false);
    }
}
