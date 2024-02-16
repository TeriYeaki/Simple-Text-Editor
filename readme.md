# Simple Text Editor

This project is a Java-based text editor that implements basic functionalities like undo, redo, save, and clear 
operations using the Command design pattern. It demonstrates the use of design patterns to create a flexible and 
extensible application that separates the user interface from the logic of executing commands.

## Features 🌟

* **Undo and Redo Operations**: Allows users to undo or redo their actions, providing a more forgiving user interface.
* **Save Operation**: Users can save their current text, which can then be accessed or modified later.
* **Clear Operation**: Clears the current text and history, providing a clean slate for the user.
* **Memento Pattern for State Restoration**: Implements the Memento design pattern to save and restore the state of 
the text editor.
* **Observer Pattern for UI Updates**: Utilizes the Observer design pattern to update the user interface in response to 
changes in the text editor's state.
* **Command Pattern for Operation Execution**: Each user action (save, undo, redo, clear) is encapsulated as a command 
object, allowing for flexible and extensible command execution.

## How to Run ⚙️
To run this application, ensure you have Java installed on your system. Compile and run the `MainProgram.java` class. 
This will launch the text editor UI where you can test the functionalities.
```bash
javac MainProgram.java
java MainProgram
```

## Project Structure 🗂️
**main**: Contains the main entry point of the application.
* **main.command**: Defines the Command interface and its concrete implementations for each action.
* **main.memento**: Contains the History and SnapShot classes to manage the state history of the text editor.
* **main.observer**: Defines the Observer and Subject interfaces for updating the UI in response to state changes.
* **main.TextEditor**: The core class that represents the text editor, implementing the subject interface.
* **main.userInterface**: Contains the JavaFrameUI class that creates and manages the user interface.

## Development Process 🖥️
The development of this text editor application followed a structured and iterative process, emphasizing the application
of design patterns to solve specific problems. Here's a brief overview of the steps involved:
* **Requirement Analysis**: Identified the core functionalities needed in a basic text editor, including undo, redo, 
save, and clear operations.
* **Design Phase**: Selected appropriate design patterns (Command, Memento, Observer) to implement the identified 
functionalities. This phase included creating UML diagrams and flowcharts to visualize the structure and interactions 
within the application.
* **Implementation**: Started coding the application in Java, focusing on one functionality at a time to ensure each was
properly encapsulated and followed the principles of the chosen design patterns.
* **Testing**: Conducted unit tests and integration tests to ensure that each component worked as expected and that the 
application as a whole met the initial requirements.
* **Refinement**: Based on testing feedback, made necessary adjustments to the code to fix bugs and improve the user 
interface for a better user experience.
* **Documentation**: Documented the development process, code, and usage instructions to ensure the project is 
understandable and accessible to others.

## Learning Outcomes 🧠
This project was instrumental in enhancing my understanding and application of software engineering principles, 
specifically:
* **Design Patterns Mastery**: Gained a deep understanding of how and when to use the Command, Memento, and Observer 
patterns, enhancing the modularity and flexibility of my code.
* **Java Programming Proficiency**: Improved Java programming skills, including familiarity with its standard library, 
object-oriented programming concepts, and GUI development with Swing.
* **Software Development Lifecycle (SDLC)**: Experienced the full cycle of software development, from requirements analysis 
to deployment, highlighting the importance of each phase.
* **Problem-Solving Skills**: Enhanced my ability to think critically and solve complex programming problems, particularly 
in implementing functionalities like undo/redo and managing application state.

## Proposed Improvements 💭
While the current implementation meets the basic requirements, I have identified several areas for future improvement:

* **Performance Optimization**: While the basic stack and arraylist data structure served the needs of this project. It 
is important to investigate and implement more efficient data structures for managing the history of operations to 
optimize memory usage and performance. This will become more important as the application scales to include more features
that support larger text files and richer editing capabilities.
* **Memento and Command Pattern Refinement**: The current implementation of the Memento pattern could be improved to 
provide more granular control over the state restoration process, allowing for partial restoration of the text editor's
state. Currently, the history stores the entire state of the text which can be memory intensive for large text files as 
multiple version is stored in the history. It may be more efficient to store only the changes made to the text in the
history. One idea is to store the commands in the history instead of the entire state of the text. This means that the 
Command pattern would need to be extended to support the ability to undo and redo its own operations, and other more 
complex operations.
* **Feature Expansion**: 
  * **Improve File Saving Capability**: Current implementation does not allow the file to be saved to local storage as 
  it is merely developed for demonstration purposes. Implement file saving capability to allow users to save their
  documents to their local storage will be a very important feature to allow this application to be used in real world.
  Additionally, different saving capabilities such as auto-save, save as, and version control can be implemented to
  ensure the safety of the user's documents. This reduces the risk of losing the user's work in case of a crash or
  accidental closure of the application if the user forgets to save their work manually.
  * **Advance Text Editing**: Add more advanced features such as text formatting (bold, italic), search and replace 
  functionality, syntax highlighting for programming languages, and more to make the text editor more versatile.
  * **File Management**: Implement file management features such as opening and editing multiple files simultaneously,
  file renaming, and file organization.
* **User Interface Enhancements**: Improve the UI/UX design for a more intuitive and visually appealing experience, 
possibly incorporating modern JavaFX instead of Swing for a more modern look and feel while ensuring portability across
different operating systems.
* **Cloud Integration**: Implement cloud saving and retrieval of documents to allow users to access their files from any
devices and collaborate with others in real-time.

## Contributing 🤝
As this project is not intended for real-world use, contributions are not accepted. However, if you would like to adapt
this project for your own use, feel free to fork the repository and modify it to suit your needs. If you have any
questions or suggestions, please feel free to open an issue to discuss them.

## License 🔑
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details. Please note that this
project has been submitted to the university database. It is intended solely as an educational resource and should not
be submitted as your own work. By submitting this project as your own, you accept full responsibility for any
consequences that may arise.


## Authors and acknowledgment ✍️
This project was developed by myself with guidance from various resources including online tutorials, books, and
documentation. I would like to thank the authors of these resources for their valuable contributions to my learning
journey. The main resource used for this project was [Refactoring Guru](https://refactoring.guru/design-patterns) 
website which provides a comprehensive guide to design patterns with examples in various programming languages.


