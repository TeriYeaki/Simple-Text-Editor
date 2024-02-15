package main.command;
import main.TextEditor.TextEditor;

/**
 * Command to clear the history of the TextEditor implementing the Command Interface.
 *
 * @author Tharith Yeak
 */
public class ClearCommand implements Command{
    private final TextEditor currentTextEditor; // Stores the active TextEditor to execute the command on

    /**
     * Constructor to initialize the ClearCommand object.
     * @param textEditor the active TextEditor to be cleared
     */
    public ClearCommand(TextEditor textEditor) {
        currentTextEditor = textEditor;
    }

    /**
     * Execute the command to clear the history of the TextEditor.
     */
    @Override
    public void execute() {
        currentTextEditor.clear();
    }
}
