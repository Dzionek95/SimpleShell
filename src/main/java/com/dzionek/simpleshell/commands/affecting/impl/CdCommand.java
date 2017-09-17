package com.dzionek.simpleshell.commands.affecting.impl;

import com.dzionek.simpleshell.commands.affecting.SetterCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

import java.io.File;
import java.util.logging.FileHandler;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class CdCommand implements SetterCommand {

    public void executeSetter(ShellData shellData, String value) {
        StringBuilder stringBuilder = new StringBuilder();
        String tempPath = shellData.getCurrentDirectory();
        if (value.equals("..")) {
            shellData.setCurrentDirectory(tempPath.substring(0, tempPath.lastIndexOf("\\")));
        } else {
            stringBuilder.append(tempPath + "\\" + value);
            buildNewCurrentPath(shellData,stringBuilder);
        }
    }

    private void buildNewCurrentPath(ShellData shellData, StringBuilder stringBuilder){
        if (new File(stringBuilder.toString()).isDirectory())
            shellData.setCurrentDirectory(stringBuilder.toString());
    }
}
