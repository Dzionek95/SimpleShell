package com.dzionek.simpleshell;

import com.dzionek.simpleshell.shellmanaging.ShellData;
import com.dzionek.simpleshell.shellmanaging.ShellManager;
import com.dzionek.simpleshell.user.UserInput;

import java.util.Scanner;

/**
 * @author Bartlomiej Janik
 * @since 9/16/2017
 */
public class MainApp {
    public static void main(String[] args) {
        ShellData shellData = new ShellData();
        UserInput userInput = new UserInput();
        new ShellManager(shellData, userInput, new Scanner(System.in)).startShell();
    }
}
