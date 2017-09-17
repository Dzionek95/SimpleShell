package com.dzionek.simpleshell.shellmanaging;

import com.dzionek.simpleshell.commands.Command;
import com.dzionek.simpleshell.user.UserInput;

import java.util.Scanner;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class ShellManager {


    private ShellData shellData;
    private Scanner sc;
    private UserInput userInput;
    private ShellMechanism shellMechanism;

    public ShellManager(ShellData shellData, UserInput userInput, Scanner sc){
        this.sc = sc;
        this.userInput = userInput;
        this.shellData = shellData;
        this.shellMechanism = new ShellMechanism(shellData,userInput);
    }

    public void startShell(){
        while(shellData.getIsRunning()){
            System.out.print(shellData.getPromptSign());
            userInput.setUserInput(sc.nextLine());
            shellMechanism.executeCommandAccordingToUserInput();
        }

    }

}
