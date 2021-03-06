package com.dzionek.simpleshell.commands.nonaffecting.displaying;

import com.dzionek.simpleshell.commands.nonaffecting.BehaviorCommand;
import com.dzionek.simpleshell.shellmanaging.ShellData;

import java.io.File;
import java.util.stream.Stream;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class TreeCommand implements BehaviorCommand {

    private StringBuilder stringBuilder = new StringBuilder();

    public void executeBehavior(ShellData shellData) {
        buildTreeOfDirectories(shellData.getCurrentDirectory());
    }

    private void buildTreeOfDirectories(String path) {
        File[] tempFileList = new File(path).listFiles();
        if (itIsPossibleToBuildTree(tempFileList)) {
            Stream.of(tempFileList)
                    .filter(file -> file.isDirectory())
                    .forEach(directory -> {
                        System.out.println(stringBuilder + directory.getName());
                        stringBuilder.append("-");
                        buildTreeOfDirectories(directory.toString());
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    });
        } else {
            System.out.println("Something is wrong or no directories was found");
        }
    }

    private boolean itIsPossibleToBuildTree(File[] tempFileList) {
        return !(tempFileList.length == 0 || tempFileList == null);
    }
}
