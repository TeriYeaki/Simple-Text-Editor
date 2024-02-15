package main.memento;

import java.util.Stack;

/**
 * The History class is responsible for storing snapshots of a text editor and managing its timeline.
 * It acts as a caretaker, holding a list of all the snapshots and providing methods to store new snapshots
 * and retrieve existing ones.
 *
 * @author Tharith Yeak
 */
public class History {
    private final Stack<SnapShot> undoStack = new Stack<>();
    private final Stack<SnapShot> redoStack = new Stack<>();
    private SnapShot currentSnapShot = null;
    private String commandFeedback;

    /**
     * Save the given text as a new snapshot in the history.
     * If the new text is the same as the last saved text, it will not be saved.
     *
     * @param newText The text to be saved as a snapshot in the history
     */
    public void save(String newText) {
        if (currentSnapShot != null && newText.equals(currentSnapShot.getSavedText())) {
            commandFeedback = "History: Duplicated text. Text is not saved in the history.";
            return;
        }

        if (currentSnapShot != null) {
            undoStack.push(currentSnapShot);
        }

        currentSnapShot = new SnapShot(newText);
        redoStack.clear();
        commandFeedback = "History: Text is saved in the history.";
    }

    /**
     * Undo the last operation and return the text that was undone.
     * If there are no more undo steps, it returns null.
     *
     * @return The text that was undone, or null if there are no more undo steps
     */
    public String undo() {
        if (undoStack.isEmpty()) {
            commandFeedback = "History: No more undo step.";
            return null;
        }

        redoStack.push(currentSnapShot);
        currentSnapShot = undoStack.pop();
        commandFeedback = "History: Undone to previous step.";
        return currentSnapShot.getSavedText();
    }

    /**
     * Redo the last undone operation and return the text that was redone.
     * If there are no more redo steps, it returns null.
     *
     * @return The text that was redone, or null if there are no more redo steps
     */
    public String redo() {
        if (redoStack.isEmpty()) {
            commandFeedback = "History: No more redo step.";
            return null;
        }

        undoStack.push(currentSnapShot);
        currentSnapShot = redoStack.pop();
        commandFeedback = "History: Redone to next step.";
        return currentSnapShot.getSavedText();
    }

    /**
     * Check if an undo operation is possible.
     *
     * @return true if an undo operation is possible, false otherwise
     */
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    /**
     * Check if a redo operation is possible.
     *
     * @return true if a redo operation is possible, false otherwise
     */
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    /**
     * Clear the entire history, removing all stored snapshots.
     */
    public void clearHistory() {
        undoStack.clear();
        redoStack.clear();
        currentSnapShot = null;
        commandFeedback = "History: History is cleared.";
    }

    /**
     * Get the feedback message from the last history operation.
     *
     * @return The feedback message from the last history operation
     */
    public String getCommandFeedback() {
        return commandFeedback;
    }
}
