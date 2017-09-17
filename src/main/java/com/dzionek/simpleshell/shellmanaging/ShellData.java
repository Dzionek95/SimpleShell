package com.dzionek.simpleshell.shellmanaging;

import com.dzionek.simpleshell.commands.Commands;
import com.dzionek.simpleshell.commands.affecting.SetterCommand;
import com.dzionek.simpleshell.commands.affecting.impl.CdCommand;
import com.dzionek.simpleshell.commands.affecting.impl.PromptCommand;
import com.dzionek.simpleshell.commands.nonaffecting.BehaviorCommand;
import com.dzionek.simpleshell.commands.nonaffecting.displaying.DirCommand;
import com.dzionek.simpleshell.commands.nonaffecting.displaying.HelpCommand;
import com.dzionek.simpleshell.commands.nonaffecting.displaying.TreeCommand;
import com.dzionek.simpleshell.commands.nonaffecting.managing.ExitCommand;

import java.util.EnumMap;
import java.util.Map;


/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class ShellData {

    private String promptSign = "[MyShell] $> ";
    private boolean isRunning = true;
    private String currentDirectory = System.getProperty("user.dir");
    private Map<Commands, SetterCommand> mapOfAffectingCommands = new EnumMap<>(Commands.class);
    private Map<Commands, BehaviorCommand> mapOfNonAffectingCommands = new EnumMap<>(Commands.class);

    public ShellData() {
        populateDataOfAffectingCommands();
        populateDataOfNonAffectingCommands();
    }

    private void populateDataOfNonAffectingCommands() {
        mapOfNonAffectingCommands.put(Commands.dir, new DirCommand());
        mapOfNonAffectingCommands.put(Commands.tree, new TreeCommand());
        mapOfNonAffectingCommands.put(Commands.exit, new ExitCommand());
        mapOfNonAffectingCommands.put(Commands.help, new HelpCommand());
    }

    private void populateDataOfAffectingCommands() {
        mapOfAffectingCommands.put(Commands.cd, new CdCommand());
        mapOfAffectingCommands.put(Commands.prompt, new PromptCommand());
    }

    public Map<Commands, SetterCommand> getMapOfAffectingCommands() {
        return mapOfAffectingCommands;
    }

    public Map<Commands, BehaviorCommand> getMapOfNonAffectingCommands() {
        return mapOfNonAffectingCommands;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    String getPromptSign() {
        return promptSign;
    }

    public void setPromptSign(String promptSign) {
        this.promptSign = String.format("[MyShell] %s $> ", promptSign);
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    boolean getIsRunning() {
        return isRunning;
    }
}
