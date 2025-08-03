package com.todoapp;

/**
 * Task class representing a single todo item
 * Demonstrates object-oriented programming concepts
 */
public class Task {
    private static int idCounter = 1; // Static counter for unique IDs
    private int id;
    private String description;
    private boolean isCompleted;
    
    /**
     * Constructor to create a new task
     * @param description The task description
     */
    public Task(String description) {
        this.id = idCounter++;
        this.description = description;
        this.isCompleted = false;
    }
    
    // Getter methods
    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    // Setter methods
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void markAsCompleted() {
        this.isCompleted = true;
    }
    
    public void markAsIncomplete() {
        this.isCompleted = false;
    }
    
    /**
     * String representation of the task
     * @return Formatted string showing task details
     */
    @Override
    public String toString() {
        String status = isCompleted ? "[✓]" : "[ ]";
        return String.format("%d. %s %s", id, status, description);
    }
    
    /**
     * Equals method for comparing tasks
     * @param obj The object to compare with
     * @return true if tasks have the same ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id;
    }
    
    /**
     * Hash code method for the task
     * @return hash code based on task ID
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
