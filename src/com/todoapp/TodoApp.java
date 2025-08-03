package com.todoapp;

import java.util.Scanner;
import java.util.List;

/**
 * TodoApp - Main application class for the command-line todo manager
 * Demonstrates Java fundamentals, OOP, and user interaction
 */
public class TodoApp {
    private TaskManager taskManager;
    private Scanner scanner;
    private boolean isRunning;
    
    /**
     * Constructor initializes the application
     */
    public TodoApp() {
        this.taskManager = new TaskManager();
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }
    
    /**
     * Main method - entry point of the application
     */
    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        app.run();
    }
    
    /**
     * Main application loop
     */
    public void run() {
        displayWelcomeMessage();
        
        while (isRunning) {
            displayMenu();
            int choice = getUserChoice();
            processChoice(choice);
        }
        
        displayGoodbyeMessage();
        scanner.close();
    }
    
    /**
     * Display welcome message
     */
    private void displayWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        Welcome to Todo Manager       ║");
        System.out.println("║     Your Simple Task Management      ║");
        System.out.println("║            Application               ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
    }
    
    /**
     * Display the main menu
     */
    private void displayMenu() {
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│              MAIN MENU              │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1. Add Task                         │");
        System.out.println("│ 2. View All Tasks                   │");
        System.out.println("│ 3. View Pending Tasks               │");
        System.out.println("│ 4. View Completed Tasks             │");
        System.out.println("│ 5. Mark Task as Complete            │");
        System.out.println("│ 6. Mark Task as Incomplete          │");
        System.out.println("│ 7. Delete Task                      │");
        System.out.println("│ 8. Show Statistics                  │");
        System.out.println("│ 9. Clear All Tasks                  │");
        System.out.println("│ 0. Exit                             │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("Enter your choice (0-9): ");
    }
    
    /**
     * Get user choice from input
     * @return The user's menu choice
     */
    private int getUserChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return choice;
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }
    
    /**
     * Process the user's menu choice
     * @param choice The menu choice
     */
    private void processChoice(int choice) {
        System.out.println();
        
        switch (choice) {
            case 1:
                addNewTask();
                break;
            case 2:
                viewAllTasks();
                break;
            case 3:
                viewPendingTasks();
                break;
            case 4:
                viewCompletedTasks();
                break;
            case 5:
                markTaskComplete();
                break;
            case 6:
                markTaskIncomplete();
                break;
            case 7:
                deleteTask();
                break;
            case 8:
                showStatistics();
                break;
            case 9:
                clearAllTasks();
                break;
            case 0:
                isRunning = false;
                break;
            default:
                System.out.println("❌ Invalid choice. Please enter a number between 0-9.");
        }
        
        if (isRunning) {
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            System.out.println();
        }
    }
    
    /**
     * Add a new task
     */
    private void addNewTask() {
        System.out.println("➕ ADD NEW TASK");
        System.out.println("───────────────");
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        
        if (description.isEmpty()) {
            System.out.println("❌ Task description cannot be empty!");
            return;
        }
        
        try {
            Task newTask = taskManager.addTask(description);
            System.out.println("✅ Task added successfully!");
            System.out.println("   " + newTask.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * View all tasks
     */
    private void viewAllTasks() {
        System.out.println("📋 ALL TASKS");
        System.out.println("─────────────");
        
        List<Task> tasks = taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found. Add some tasks to get started!");
            return;
        }
        
        for (Task task : tasks) {
            System.out.println("   " + task.toString());
        }
        System.out.println("\nTotal tasks: " + tasks.size());
    }
    
    /**
     * View pending tasks only
     */
    private void viewPendingTasks() {
        System.out.println("⏳ PENDING TASKS");
        System.out.println("────────────────");
        
        List<Task> pendingTasks = taskManager.getPendingTasks();
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks. Great job! 🎉");
            return;
        }
        
        for (Task task : pendingTasks) {
            System.out.println("   " + task.toString());
        }
        System.out.println("\nPending tasks: " + pendingTasks.size());
    }
    
    /**
     * View completed tasks only
     */
    private void viewCompletedTasks() {
        System.out.println("✅ COMPLETED TASKS");
        System.out.println("──────────────────");
        
        List<Task> completedTasks = taskManager.getCompletedTasks();
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks yet. Start completing some tasks!");
            return;
        }
        
        for (Task task : completedTasks) {
            System.out.println("   " + task.toString());
        }
        System.out.println("\nCompleted tasks: " + completedTasks.size());
    }
    
    /**
     * Mark a task as complete
     */
    private void markTaskComplete() {
        System.out.println("✅ MARK TASK AS COMPLETE");
        System.out.println("────────────────────────");
        
        if (taskManager.getTotalTaskCount() == 0) {
            System.out.println("No tasks available to mark as complete.");
            return;
        }
        
        // Show pending tasks
        List<Task> pendingTasks = taskManager.getPendingTasks();
        if (pendingTasks.isEmpty()) {
            System.out.println("All tasks are already completed! 🎉");
            return;
        }
        
        System.out.println("Pending tasks:");
        for (Task task : pendingTasks) {
            System.out.println("   " + task.toString());
        }
        
        System.out.print("\nEnter task ID to mark as complete: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine().trim());
            if (taskManager.markTaskComplete(taskId)) {
                System.out.println("✅ Task marked as complete!");
            } else {
                System.out.println("❌ Task with ID " + taskId + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid task ID (number).");
        }
    }
    
    /**
     * Mark a task as incomplete
     */
    private void markTaskIncomplete() {
        System.out.println("⏳ MARK TASK AS INCOMPLETE");
        System.out.println("──────────────────────────");
        
        if (taskManager.getTotalTaskCount() == 0) {
            System.out.println("No tasks available to mark as incomplete.");
            return;
        }
        
        // Show completed tasks
        List<Task> completedTasks = taskManager.getCompletedTasks();
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks to mark as incomplete.");
            return;
        }
        
        System.out.println("Completed tasks:");
        for (Task task : completedTasks) {
            System.out.println("   " + task.toString());
        }
        
        System.out.print("\nEnter task ID to mark as incomplete: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine().trim());
            if (taskManager.markTaskIncomplete(taskId)) {
                System.out.println("⏳ Task marked as incomplete!");
            } else {
                System.out.println("❌ Task with ID " + taskId + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid task ID (number).");
        }
    }
    
    /**
     * Delete a task
     */
    private void deleteTask() {
        System.out.println("🗑️  DELETE TASK");
        System.out.println("───────────────");
        
        if (taskManager.getTotalTaskCount() == 0) {
            System.out.println("No tasks available to delete.");
            return;
        }
        
        // Show all tasks
        viewAllTasks();
        
        System.out.print("\nEnter task ID to delete: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine().trim());
            
            Task taskToDelete = taskManager.getTaskById(taskId);
            if (taskToDelete != null) {
                System.out.print("Are you sure you want to delete \"" + taskToDelete.getDescription() + "\"? (y/N): ");
                String confirmation = scanner.nextLine().trim().toLowerCase();
                
                if (confirmation.equals("y") || confirmation.equals("yes")) {
                    if (taskManager.deleteTask(taskId)) {
                        System.out.println("🗑️  Task deleted successfully!");
                    }
                } else {
                    System.out.println("Delete operation cancelled.");
                }
            } else {
                System.out.println("❌ Task with ID " + taskId + " not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid task ID (number).");
        }
    }
    
    /**
     * Show task statistics
     */
    private void showStatistics() {
        System.out.println("📊 TASK STATISTICS");
        System.out.println("──────────────────");
        
        int total = taskManager.getTotalTaskCount();
        int completed = taskManager.getCompletedTaskCount();
        int pending = taskManager.getPendingTaskCount();
        
        System.out.println("Total Tasks:     " + total);
        System.out.println("Completed Tasks: " + completed);
        System.out.println("Pending Tasks:   " + pending);
        
        if (total > 0) {
            double completionRate = (double) completed / total * 100;
            System.out.printf("Completion Rate: %.1f%%\n", completionRate);
            
            // Progress bar
            System.out.print("Progress: [");
            int progressBarLength = 20;
            int filledLength = (int) (progressBarLength * completionRate / 100);
            
            for (int i = 0; i < progressBarLength; i++) {
                if (i < filledLength) {
                    System.out.print("█");
                } else {
                    System.out.print("░");
                }
            }
            System.out.println("]");
        }
    }
    
    /**
     * Clear all tasks
     */
    private void clearAllTasks() {
        System.out.println("🗑️  CLEAR ALL TASKS");
        System.out.println("───────────────────");
        
        if (taskManager.getTotalTaskCount() == 0) {
            System.out.println("No tasks to clear.");
            return;
        }
        
        System.out.print("Are you sure you want to delete ALL tasks? This cannot be undone! (y/N): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();
        
        if (confirmation.equals("y") || confirmation.equals("yes")) {
            taskManager.clearAllTasks();
            System.out.println("🗑️  All tasks have been cleared!");
        } else {
            System.out.println("Clear operation cancelled.");
        }
    }
    
    /**
     * Display goodbye message
     */
    private void displayGoodbyeMessage() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         Thank you for using         ║");
        System.out.println("║          Todo Manager!              ║");
        System.out.println("║        Stay productive! 🚀          ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
