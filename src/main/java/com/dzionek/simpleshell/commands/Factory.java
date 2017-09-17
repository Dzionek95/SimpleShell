package com.dzionek.simpleshell.commands;

import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * This interface is for creating factory for Behaviors or Setters commands
 *
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public interface Factory<T> {

    T pickProperCommand(ShellData shellData, Commands commands);

}
