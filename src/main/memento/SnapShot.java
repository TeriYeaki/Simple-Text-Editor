package main.memento;

/**
 * The `SnapShot` class represents a memento that stores the state of a text editor at a specific time.
 * It provides a method to retrieve the saved text from the snapshot.
 *
 * @author Tharith Yeak
 */
public class SnapShot {

    /**
     * The saved text in the snapshot.
     */
    private final String text;

    /**
     * Constructs a new `SnapShot` object with the specified text.
     *
     * @param text The text to be saved in the snapshot.
     */
    public SnapShot(String text) {
        this.text = text;
    }

    /**
     * Retrieves the content of the snapshot.
     *
     * @return The saved text from the snapshot.
     */
    public String getSavedText() {
        return text;
    }
}
