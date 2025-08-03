@echo off
echo Compiling Simple Todo App...
echo.

REM Create output directory if it doesn't exist
if not exist "bin" mkdir bin

REM Compile Java files
javac -d bin src\com\todoapp\*.java

if %ERRORLEVEL% EQU 0 (
    echo ✅ Compilation successful!
    echo.
    echo To run the application, use:
    echo java -cp bin com.todoapp.TodoApp
    echo.
    echo Or run directly:
    cd bin
    java com.todoapp.TodoApp
) else (
    echo ❌ Compilation failed!
    pause
)
