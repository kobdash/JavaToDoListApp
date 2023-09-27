package com.mycompany.todolistapp;

import ToDoListAppGUI.ToDoListAppGUI; // Import your GUI class

/**
 * Main class for your To-Do List Application.
 */
public class ToDoListApp {

    public static void main(String[] args) {
        // Create an instance of your GUI class
        ToDoListAppGUI guiApp = new ToDoListAppGUI();

        // Set the behavior for when the GUI window is closed
        guiApp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        // Make the GUI window visible
        guiApp.setVisible(true);
    }
}