# Quick Start Guide

## Running the Application

### Method 1: Using the Batch File (Recommended for Windows)
```powershell
.\compile.bat
```

### Method 2: Manual Compilation and Execution
```powershell
# Compile the Java files
javac -d . src\com\todoapp\*.java

# Run the interactive application
java com.todoapp.TodoApp

# Or run the demo
java com.todoapp.TodoAppDemo
```

### Method 3: Using separate bin directory
```powershell
# Create bin directory and compile
mkdir bin
javac -d bin src\com\todoapp\*.java

# Run from bin directory
java -cp bin com.todoapp.TodoApp
```

## Application Features

The Todo App includes the following menu options:

1. **Add Task** - Create new tasks with descriptions
2. **View All Tasks** - Display all tasks with status
3. **View Pending Tasks** - Show only incomplete tasks
4. **View Completed Tasks** - Show only finished tasks
5. **Mark Task as Complete** - Change task status to completed
6. **Mark Task as Incomplete** - Change task status back to pending
7. **Delete Task** - Remove a task permanently
8. **Show Statistics** - Display progress and completion rate
9. **Clear All Tasks** - Remove all tasks (with confirmation)
0. **Exit** - Quit the application

## Sample Session

```
Enter your choice (0-9): 1

➕ ADD NEW TASK
───────────────
Enter task description: Study Java collections
✅ Task added successfully!
   1. [ ] Study Java collections

Enter your choice (0-9): 5

✅ MARK TASK AS COMPLETE
────────────────────────
Pending tasks:
   1. [ ] Study Java collections

Enter task ID to mark as complete: 1
✅ Task marked as complete!
```

## Tips for Using the Application

- Task IDs are automatically assigned and cannot be changed
- Use descriptive task names for better organization
- Check statistics regularly to track your progress
- Use the confirmation prompts to avoid accidental deletions
- The application stores data in memory only (data is lost when you exit)

## Troubleshooting

### Common Issues:

1. **"javac is not recognized"** - Make sure JDK is installed and added to PATH
2. **"java is not recognized"** - Ensure Java is properly installed
3. **ClassNotFoundException** - Make sure you're in the correct directory
4. **Compilation errors** - Check that all .java files are in the correct package structure

### Verification Steps:

1. Check Java installation: `java -version`
2. Check compiler: `javac -version`
3. Verify file structure matches the package declaration
4. Ensure you're running commands from the project root directory
