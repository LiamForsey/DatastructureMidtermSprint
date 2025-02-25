package org.example;

public class User {
    private String username;
    private TaskList taskList;


    public User(String username) {
        this.username = username;
        this.taskList = new TaskList();
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }

    // function for adding a task to the user's to-do list
    public void addTask(String taskDescription) {
        taskList.addTask(taskDescription);
    }

    // function to mark a task as completed in the user's list
    public void markTaskAsDone(String taskDescription) {
        taskList.markTaskAsCompleted(taskDescription);
    }

    // function to view all tasks in the user's to-do list
    public void seeAllTasks() {
        System.out.println("Tasks for " + username + ":");
        taskList.printTasks();
    }
}