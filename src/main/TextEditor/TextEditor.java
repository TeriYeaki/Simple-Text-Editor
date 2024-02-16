package main.TextEditor;

import main.memento.History;
import main.observer.CommandUIObserver;
import main.observer.CommandUISubject;

import java.util.ArrayList;
import java.util.List;

/**
 * The TextEditor class is responsible for managing the state of the text editor.
 * It provides functionality to save snapshots of the text, restore previous versions,
 * and retrieve the current version of the text.
 */
public class TextEditor implements CommandUISubject {

    private String text;
    private final History history;
    private final List<CommandUIObserver> commandUIObservers = new ArrayList<>();

    /**
     * Constructs a new text editor with an empty text.
     */
    public TextEditor() {
        text = "";
        history = new History();
    }

    /**
     * Retrieves the current version of the text in the editor.
     *
     * @return the current version of the text
     */
    public String getText() {
        return text;
    }

    /**
     * Saves a new version of the text and updates the history.
     *
     * @param newText the new version of the text
     */
    public void save(String newText) {
        text = newText;
        history.save(text);
        notifyObservers();
    }

    /**
     * Restores the previous version of the text.
     */
    public void undo() {
        text = history.undo();
        notifyObservers();
    }

    /**
     * Restores the next version of the text.
     */
    public void redo() {
        text = history.redo();
        notifyObservers();
    }

    /**
     * Clears the history and the text.
     */
    public void clear() {
        history.clearHistory();
        text = "";
        notifyObservers();
    }

    /**
     * Checks if undo operation is possible.
     *
     * @return true if undo is possible, false otherwise
     */
    public boolean canUndo() {
        return history.canUndo();
    }

    /**
     * Checks if redo operation is possible.
     *
     * @return true if redo is possible, false otherwise
     */
    public boolean canRedo() {
        return history.canRedo();
    }

    /**
     * Retrieves the feedback from the history for the last command.
     *
     * @return the command feedback
     */
    public String getCommandFeedback() {
        return history.getCommandFeedback();
    }

    /**
     * Registers an observer to receive notifications when a change occurs.
     *
     * @param observer the observer to be registered
     */
    @Override
    public void registerObserver(CommandUIObserver observer) {
        commandUIObservers.add(observer);
    }

    /**
     * Removes an observer from receiving notifications.
     *
     * @param observer the observer to be removed
     */
    @Override
    public void removeObserver(CommandUIObserver observer) {
        commandUIObservers.remove(observer);
    }

    /**
     * Notifies all registered observers about a change in the subject.
     */
    @Override
    public void notifyObservers() {
        for (CommandUIObserver commandUIObserver : commandUIObservers) {
            commandUIObserver.update();
        }

    }
}
