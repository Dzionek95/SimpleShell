package com.dzionek.simpleshell.commands.nonaffecting.displaying;

import com.dzionek.simpleshell.commands.nonaffecting.BehaviorCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

import java.io.File;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class DirCommand implements BehaviorCommand {

    public void executeBehavior(ShellData shellData) {
        StringBuilder stringBuilder = new StringBuilder();
        File[] filesInDirectory = new File(shellData.getCurrentDirectory()).listFiles();
        for (int i = 0; i < filesInDirectory.length - 1; ++i) {
            File tempFile = filesInDirectory[i];
            if (tempFile.isDirectory()) {
                stringBuilder.append("DIR    ")
                        .append(tempFile.getName())
                        .append("\n");
            } else {
                stringBuilder.append("FILE   ")
                        .append(tempFile.getName())
                        .append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
