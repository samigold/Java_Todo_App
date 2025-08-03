package com.todoapp;

/**
 * Simple test class to demonstrate the Todo App functionality
 */
public class TodoAppDemo {
    public static void main(String[] args) {
        System.out.println("=== Todo App Demo ===\n");
        
        // Create a task manager
        TaskManager taskManager = new TaskManager();
        
        // Add some sample tasks
        System.out.println("Adding sample tasks...");
        Task task1 = taskManager.addTask("Learn Java OOP concepts");
        Task task2 = taskManager.addTask("Complete Todo App project");
        Task task3 = taskManager.addTask("Practice with ArrayList");
        Task task4 = taskManager.addTask("Write documentation");
        
        // Display all tasks
        System.out.println("\n📋 All Tasks:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println("   " + task.toString());
        }
        
        // Mark some tasks as complete
        System.out.println("\n✅ Marking tasks as complete...");
        taskManager.markTaskComplete(1);
        taskManager.markTaskComplete(3);
        
        // Display pending tasks
        System.out.println("\n⏳ Pending Tasks:");
        for (Task task : taskManager.getPendingTasks()) {
            System.out.println("   " + task.toString());
        }
        
        // Display completed tasks
        System.out.println("\n✅ Completed Tasks:");
        for (Task task : taskManager.getCompletedTasks()) {
            System.out.println("   " + task.toString());
        }
        
        // Show statistics
        System.out.println("\n📊 Statistics:");
        System.out.println("   Total tasks: " + taskManager.getTotalTaskCount());
        System.out.println("   Completed: " + taskManager.getCompletedTaskCount());
        System.out.println("   Pending: " + taskManager.getPendingTaskCount());
        
        double completionRate = (double) taskManager.getCompletedTaskCount() / taskManager.getTotalTaskCount() * 100;
        System.out.printf("   Completion rate: %.1f%%\n", completionRate);
        
        System.out.println("\n=== Demo completed successfully! ===");
        System.out.println("To run the interactive application, use: java com.todoapp.TodoApp");
    }
}
