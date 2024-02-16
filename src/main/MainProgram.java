package main;

import main.userInterface.DisplayInterface;
import main.userInterface.JavaFrameUI;

/**
 * This class represents the main program that initializes and runs the application.
 *
 * @author Tharith Yeak
 */
public class MainProgram {

    /**
     * The entry point of the application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        DisplayInterface displayInterface = new JavaFrameUI();
        displayInterface.display();
    }
}
