package com.dzionek.simpleshell.commands.nonaffecting;

import com.dzionek.simpleshell.commands.Command;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * Thid interface is for commands that are opearing on ShellData
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public interface BehaviorCommand extends Command{

    void executeBehavior(ShellData shellData);

}
