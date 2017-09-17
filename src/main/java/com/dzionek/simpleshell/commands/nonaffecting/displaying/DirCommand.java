package com.dzionek.simpleshell.commands.nonaffecting.displaying;

import com.dzionek.simpleshell.commands.nonaffecting.BehaviorCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

import java.io.File;
import java.util.stream.Stream;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class DirCommand implements BehaviorCommand {

    public void executeBehavior(ShellData shellData) {
        StringBuilder stringBuilder = new StringBuilder();
        File[] filesInDirectory = new File(shellData.getCurrentDirectory()).listFiles();
        Stream.of(filesInDirectory).forEach(file -> {
            if (file.isDirectory()) {
                stringBuilder.append("DIR    ")
                        .append(file.getName())
                        .append("\n");
            } else {
                stringBuilder.append("FILE   ")
                        .append(file.getName())
                        .append("\n");
            }
        });

        System.out.print(stringBuilder.toString());
    }
}
