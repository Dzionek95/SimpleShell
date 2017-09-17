package com.dzionek.simpleshell.commands.affecting;

import com.dzionek.simpleshell.commands.Command;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * This interface is for methods that affects Shell data
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public interface SetterCommand extends Command {

    void executeSetter(ShellData shellData, String value);

}
