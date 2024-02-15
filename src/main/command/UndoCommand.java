package main.command;
import main.TextEditor.TextEditor;

/**
 * Command to undo the last action performed in the TextEditor.
 *
 * @author Tharith Yeak
 */
public class UndoCommand implements Command {
    private final TextEditor currentTextEditor;

    /**
     * Constructs an UndoCommand object with the specified TextEditor.
     *
     * @param textEditor the active TextEditor
     */
    public UndoCommand(TextEditor textEditor) {
        currentTextEditor = textEditor;
    }

    /**
     * Executes the command to undo the last action in the TextEditor.
     */
    @Override
    public void execute() {
        currentTextEditor.undo();
    }
}
