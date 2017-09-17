package com.dzionek.simpleshell.commands;

import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public interface Factory<T> {

   T pickProperCommand(ShellData shellData, Commands commands);

}
