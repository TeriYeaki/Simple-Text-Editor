package main.observer;

/**
 * The CommandUISubject interface represents the subject in the Command User Interface (UI) observer pattern.
 *
 * @author Tharith Yeak
 */
public interface CommandUISubject {
    /**
     * Registers an observer to receive notifications when a change occurs.
     *
     * @param observer the observer to be registered
     */
    void registerObserver(CommandUIObserver observer);

    /**
     * Removes an observer from receiving notifications.
     *
     * @param observer the observer to be removed
     */
    void removeObserver(CommandUIObserver observer);

    /**
     * Notifies all registered observers about a change in the subject.
     */
    void notifyObservers();
}
