package com.mycompany.todolistapp;

import java.time.LocalDate;

public class Task {
    private String taskName;
    private LocalDate dueDate;
    private Priority priority;
    private boolean completed;

    public Task(String taskName, LocalDate dueDate, Priority priority) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false; // Initialize as not completed
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task Name: " + taskName + ", Due Date: " + dueDate + ", Priority: " + priority + ", Completed: " + completed;
    }

    // Enum for Task Priority
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    // Method to parse Priority from String
    public static Priority parsePriority(String priorityStr) {
        switch (priorityStr.toLowerCase()) {
            case "low":
                return Priority.LOW;
            case "medium":
                return Priority.MEDIUM;
            case "high":
                return Priority.HIGH;
            default:
                throw new IllegalArgumentException("Invalid priority: " + priorityStr);
        }
    }

    // Method to parse LocalDate from String
    public static LocalDate parseDueDate(String dueDateStr) {
        try {
            return LocalDate.parse(dueDateStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid due date format. Please use 'yyyy-MM-dd' format.");
        }
    }
}