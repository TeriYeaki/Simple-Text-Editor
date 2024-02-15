package main.command;

import main.TextEditor.TextEditor;

/**
 * Command to redo the last action of the TextEditor class.
 *
 * @author Tharith Yeak
 */
public class RedoCommand implements Command {
    private final TextEditor currentTextEditor;

    /**
     * Constructor to initialize the RedoCommand.
     *
     * @param textEditor The active text editor.
     */
    public RedoCommand(TextEditor textEditor) {
        currentTextEditor = textEditor;
    }

    /**
     * Executes the command to redo the last action of the text editor.
     */
    @Override
    public void execute() {
        currentTextEditor.redo();
    }
}
