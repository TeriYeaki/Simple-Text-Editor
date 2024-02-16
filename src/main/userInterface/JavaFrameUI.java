package main.userInterface;
import main.observer.CommandUIObserver;
import main.TextEditor.TextEditor;
import main.command.ClearCommand;
import main.command.RedoCommand;
import main.command.SaveCommand;
import main.command.UndoCommand;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JavaFrameUI implements DisplayInterface, CommandUIObserver {
    private final JButton saveButton, undoButton, redoButton, clearButton;
    private final JTextArea theText = new JTextArea();
    private final JFrame mainFrame = new JFrame();
    private final JPanel headerPanel = new JPanel();
    private final JLabel headerLabel = new JLabel("", JLabel.LEFT);
    private final JPanel buttonPanel = new JPanel();
    private final JPanel feedbackPanel = new JPanel();
    private final JLabel feedbackLabel = new JLabel("", JLabel.LEFT);
    private final JScrollPane textPanel = new JScrollPane();
    private final TextEditor textEditor = new TextEditor();

    public JavaFrameUI() {
        // register self to main.TextEditor Observer list
        textEditor.registerObserver(this);

        // create new JButtons
        saveButton = createNewButton("Save", true);
        undoButton = createNewButton("Undo", false);
        redoButton = createNewButton("Redo", false);
        clearButton = createNewButton("Clear", false);
        // add action listeners to the buttons
        saveButton.addActionListener(e -> new SaveCommand(textEditor, this).execute());
        undoButton.addActionListener(e -> new UndoCommand(textEditor).execute());
        redoButton.addActionListener(e -> new RedoCommand(textEditor).execute());
        clearButton.addActionListener(e -> new ClearCommand(textEditor).execute());
        // create new JPanel to hold the buttons
        buttonPanel.setPreferredSize(new Dimension(500, 50));
        buttonPanel.add(saveButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);
        buttonPanel.add(clearButton);

        // Set header panel properties and content
        headerPanel.setPreferredSize(new Dimension(500, 100));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
        headerLabel.setText("Text:");
        headerPanel.setLayout(new GridLayout(2, 1));
        headerPanel.add(buttonPanel);
        headerPanel.add(headerLabel);

        // set text panel properties and content
        theText.setLineWrap(true);
        theText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        textPanel.setViewportView(theText);
        textPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        // Set feedback panel properties and content
        feedbackPanel.setPreferredSize(new Dimension(500, 50));
        feedbackPanel.add(feedbackLabel);
    }

    @Override
    public void display() {
        // frame properties
        mainFrame.setSize(500, 800);
        mainFrame.setTitle("Text Editor");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the panels to the frame
        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(textPanel, BorderLayout.CENTER);
        mainFrame.add(feedbackPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    @Override
    public String getTextInput() {
        return theText.getText();
    }

    private void updateButtons() {
        undoButton.setEnabled(textEditor.canUndo());
        redoButton.setEnabled(textEditor.canRedo());
        clearButton.setEnabled(textEditor.canUndo() || textEditor.canRedo());
    }

    private void displayFeedback() {
        feedbackLabel.setText(textEditor.getCommandFeedback());
        Timer displayTextTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedbackLabel.setText("");
            }
        });
        displayTextTimer.start();
    }

    private JButton createNewButton(String name, boolean isEnabled) {
        JButton newButton = new JButton(name);
        newButton.setEnabled(isEnabled);
        return newButton;
    }

    @Override
    public void update() {
        this.updateButtons();
        this.displayFeedback();
        theText.setText(textEditor.getText());
    }
}
