package main.observer;

/**
 * Interface for observing changes in the Command User Interface (UI).
 *
 * @author Tharith Yeak
 */
public interface CommandUIObserver {

    /**
     * Method called when the Command UI has been updated.
     */
    void update();
}
