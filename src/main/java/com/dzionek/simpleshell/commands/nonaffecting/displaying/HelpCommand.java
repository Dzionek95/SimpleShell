package com.dzionek.simpleshell.commands.nonaffecting.displaying;

import com.dzionek.simpleshell.commands.nonaffecting.BehaviorCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class HelpCommand implements BehaviorCommand {

    public void executeBehavior(ShellData shellData) {
        System.out.println("Help command");
    }

}
