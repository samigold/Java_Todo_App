package com.todoapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * TaskManager class to handle all task operations
 * Demonstrates collection usage and data management
 */
public class TaskManager {
    private List<Task> tasks;
    
    /**
     * Constructor initializes the task list
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    
    /**
     * Add a new task to the list
     * @param description The task description
     * @return The created task
     */
    public Task addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty");
        }
        
        Task newTask = new Task(description.trim());
        tasks.add(newTask);
        return newTask;
    }
    
    /**
     * Get all tasks
     * @return List of all tasks
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks); // Return a copy to maintain encapsulation
    }
    
    /**
     * Get a task by its ID
     * @param id The task ID
     * @return The task if found, null otherwise
     */
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
    
    /**
     * Mark a task as completed
     * @param id The task ID
     * @return true if task was found and marked complete, false otherwise
     */
    public boolean markTaskComplete(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            task.markAsCompleted();
            return true;
        }
        return false;
    }
    
    /**
     * Mark a task as incomplete
     * @param id The task ID
     * @return true if task was found and marked incomplete, false otherwise
     */
    public boolean markTaskIncomplete(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            task.markAsIncomplete();
            return true;
        }
        return false;
    }
    
    /**
     * Delete a task by ID
     * @param id The task ID
     * @return true if task was found and deleted, false otherwise
     */
    public boolean deleteTask(int id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get completed tasks
     * @return List of completed tasks
     */
    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
    
    /**
     * Get pending (incomplete) tasks
     * @return List of pending tasks
     */
    public List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }
    
    /**
     * Get the total number of tasks
     * @return Total task count
     */
    public int getTotalTaskCount() {
        return tasks.size();
    }
    
    /**
     * Get the number of completed tasks
     * @return Completed task count
     */
    public int getCompletedTaskCount() {
        return getCompletedTasks().size();
    }
    
    /**
     * Get the number of pending tasks
     * @return Pending task count
     */
    public int getPendingTaskCount() {
        return getPendingTasks().size();
    }
    
    /**
     * Clear all tasks
     */
    public void clearAllTasks() {
        tasks.clear();
    }
}
