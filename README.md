# Simple Todo App

A command-line Java application for managing daily tasks, demonstrating fundamental Java object-oriented principles and data management.

## Project Overview

This application demonstrates:
- Object-Oriented Programming concepts
- Java language basics (variables, data types, control flow)
- Classes and Objects
- Working with Numbers and Strings
- Package structure
- Collection management (ArrayList)

## Features

- ✅ Add tasks with descriptions
- 📋 View all tasks
- ⏳ View pending tasks only
- ✅ View completed tasks only
- ✅ Mark tasks as complete/incomplete
- 🗑️ Delete individual tasks
- 📊 View task statistics with progress bar
- 🗑️ Clear all tasks
- 💾 In-memory data storage using ArrayList

## Project Structure

```
Simple_todo_app/
├── src/
│   └── com/
│       └── todoapp/
│           ├── Task.java          # Task class with properties and methods
│           ├── TaskManager.java   # Task management logic
│           └── TodoApp.java       # Main application class
├── README.md
├── .gitignore
└── compile.bat                    # Windows batch file for compilation
```

## Class Descriptions

### Task.java
- Represents a single todo item
- Properties: id, description, completion status
- Methods: getters, setters, toString(), equals(), hashCode()
- Demonstrates encapsulation and object-oriented design

### TaskManager.java
- Manages collection of Task objects using ArrayList
- Provides CRUD operations (Create, Read, Update, Delete)
- Handles task filtering (completed/pending)
- Demonstrates collection usage and data management

### TodoApp.java
- Main application class with user interface
- Command-line menu system
- User input handling and validation
- Demonstrates control flow, loops, and conditionals

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line access (PowerShell, Command Prompt, or Terminal)

### Compilation and Execution

1. **Navigate to the project directory:**
   ```powershell
   cd "c:\Users\Samigold's Pc\Desktop\Simple_todo_app"
   ```

2. **Compile the Java files:**
   ```powershell
   javac -d . src\com\todoapp\*.java
   ```

3. **Run the application:**
   ```powershell
   java com.todoapp.TodoApp
   ```

### Using the Batch File (Windows)
```powershell
.\compile.bat
```

## Usage

1. **Start the application** - Run the main class
2. **Add tasks** - Choose option 1 and enter task descriptions
3. **View tasks** - Use options 2-4 to view different task lists
4. **Mark complete** - Use option 5 to complete tasks
5. **Delete tasks** - Use option 7 to remove tasks
6. **View statistics** - Use option 8 to see progress
7. **Exit** - Use option 0 to quit

## Key Java Concepts Demonstrated

### Object-Oriented Programming
- **Encapsulation**: Private fields with public getters/setters
- **Abstraction**: Task class abstracts task behavior
- **Polymorphism**: Override toString(), equals(), hashCode()

### Data Types and Variables
- **Primitive types**: int, boolean
- **Reference types**: String, ArrayList
- **Static variables**: ID counter for unique task IDs

### Control Flow
- **Loops**: for-each loops for iterating collections
- **Conditionals**: if-else statements for menu logic
- **Switch statements**: Menu option processing

### Collections
- **ArrayList**: Dynamic array for storing tasks
- **Iterator**: Safe removal during iteration
- **List interface**: Programming to interfaces

### Exception Handling
- **NumberFormatException**: Handling invalid number input
- **IllegalArgumentException**: Validating task descriptions

## Sample Output

```
╔══════════════════════════════════════╗
║        Welcome to Todo Manager       ║
║     Your Simple Task Management      ║
║            Application               ║
╚══════════════════════════════════════╝

┌─────────────────────────────────────┐
│              MAIN MENU              │
├─────────────────────────────────────┤
│ 1. Add Task                         │
│ 2. View All Tasks                   │
│ 3. View Pending Tasks               │
│ 4. View Completed Tasks             │
│ 5. Mark Task as Complete            │
│ 6. Mark Task as Incomplete          │
│ 7. Delete Task                      │
│ 8. Show Statistics                  │
│ 9. Clear All Tasks                  │
│ 0. Exit                             │
└─────────────────────────────────────┘
```

## Future Enhancements

- File-based persistence (save/load tasks)
- Task priorities and due dates
- Categories and tags
- Search and filter functionality
- Task editing capabilities

## Learning Objectives Achieved

✅ Java syntax and language basics  
✅ Object-oriented programming principles  
✅ Class and object creation  
✅ Collection management (ArrayList)  
✅ String and number handling  
✅ Package organization  
✅ User input and validation  
✅ Control flow and program structure  

## License

This project is for educational purposes and demonstrates fundamental Java programming concepts.
