package main.command;

import main.TextEditor.TextEditor;
import main.userInterface.DisplayInterface;

/**
 * Command to save the current state of the TextEditor.
 *
 * @author Tharith Yeak
 */
public class SaveCommand implements Command {
    private final TextEditor currentTextEditor;
    private final DisplayInterface currentDisplayInterface;

    /**
     * Constructor to initialize the textEditor.
     * @param textEditor The active TextEditor.
     * @param displayInterface The active display interface.
     */
    public SaveCommand(TextEditor textEditor, DisplayInterface displayInterface) {
        currentTextEditor = textEditor;
        currentDisplayInterface = displayInterface;
    }

    /**
     * Execute the command to save the current state of the TextEditor.
     */
    @Override
    public void execute() {
        currentTextEditor.save(currentDisplayInterface.getTextInput());
    }
}
