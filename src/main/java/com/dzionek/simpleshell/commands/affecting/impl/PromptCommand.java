package com.dzionek.simpleshell.commands.affecting.impl;

import com.dzionek.simpleshell.commands.affecting.SetterCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class PromptCommand implements SetterCommand {

    public void executeSetter(ShellData shellData, String value) {
        switch (value) {
            case "$cwd":
                shellData.setPromptSign(shellData.getCurrentDirectory());
                break;
            case "reset":
                shellData.setPromptSign("");
                break;
            default:
                shellData.setPromptSign(value);
        }
    }


}
