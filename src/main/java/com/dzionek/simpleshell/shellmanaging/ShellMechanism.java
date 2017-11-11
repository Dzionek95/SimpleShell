package com.dzionek.simpleshell.shellmanaging;

import com.dzionek.simpleshell.commands.Commands;
import com.dzionek.simpleshell.commands.WrongParametersException;
import com.dzionek.simpleshell.commands.affecting.AffectingCommandsFactory;
import com.dzionek.simpleshell.commands.nonaffecting.NonAffectingCommandsFactory;
import com.dzionek.simpleshell.user.UserInput;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class ShellMechanism {

    private static final int MAX_AFFECTING_COMMAND_LENGTH = 2;
    private static final int MAX_NOT_AFFECTING_COMMAND_LENGTH = 1;
    private UserInput userInput;
    private ShellData shellData;

    public ShellMechanism(ShellData shellData, UserInput userInput) {
        this.userInput = userInput;
        this.shellData = shellData;
    }

    public void executeCommandAccordingToUserInput() {
        String[] splitedUserInput = userInput.getUserInput();
        try {

            Commands command = getEnumValueOfCommand(splitedUserInput[0]);
            boolean isAffectingCommand = checkIfCommandIsAffecting(command);
            verifyIfAmountOfArgumentsIsProper(splitedUserInput, isAffectingCommand);

            if (isAffectingCommand) {
                new AffectingCommandsFactory()
                        .pickProperCommand(shellData, command)
                        .executeSetter(shellData, splitedUserInput[1]);
            } else {
                new NonAffectingCommandsFactory()
                        .pickProperCommand(shellData, command)
                        .executeBehavior(shellData);
            }
        } catch (WrongParametersException exception) {
            System.out.println(exception.getMessage());
        } catch (IllegalArgumentException exception) {
            System.out.println("Whops such command does not exists!");
        }
    }

    private void verifyIfAmountOfArgumentsIsProper(String[] splitedUserInput, boolean isAffectingCommand) {
        if (isInputProperForAffectingCommand(splitedUserInput, isAffectingCommand)
                || isInputProperForNotAffectingCommand(splitedUserInput, isAffectingCommand))
            throw new WrongParametersException("Whops too many parameteres!");
    }

    private boolean isInputProperForAffectingCommand(String[] splitedUserInput, boolean isAffectingCommand) {
        return splitedUserInput.length > MAX_AFFECTING_COMMAND_LENGTH && isAffectingCommand;
    }

    private boolean isInputProperForNotAffectingCommand(String[] splitedUserInput, boolean isAffectingCommand) {
        return splitedUserInput.length > MAX_NOT_AFFECTING_COMMAND_LENGTH && !isAffectingCommand;
    }

    private Commands getEnumValueOfCommand(String command) {
        return Commands.valueOf(command);
    }

    private boolean checkIfCommandIsAffecting(Commands command) {
        return shellData.getMapOfAffectingCommands().containsKey(command);
    }

}
