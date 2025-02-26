package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[15];
        int userCount = 0;

        while (true) {
            // Display the menu
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Adding a new user in run
                    if (userCount >= users.length) {
                        System.out.println("User limit reached!");
                        break;
                    }
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine().trim();
                    users[userCount++] = new User(username);
                    System.out.println("User added successfully!");
                    break;

                case 2: // Add a task to a user's to-do list
                    System.out.print("Enter username: ");
                    String userForTask = scanner.nextLine().trim();
                    User selectedUser = findUser(users, userForTask, userCount);
                    if (selectedUser != null) {
                        System.out.print("Enter task description: ");
                        String taskDesc = scanner.nextLine().trim();
                        selectedUser.addTask(taskDesc);
                        System.out.println("Task added successfully!");
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 3: // Mark a task as completed
                    System.out.print("Enter username: ");
                    String userForCompletion = scanner.nextLine().trim();
                    User userToComplete = findUser(users, userForCompletion, userCount);
                    if (userToComplete != null) {
                        System.out.print("Enter task description to mark as completed: ");
                        String taskComplete = scanner.nextLine().trim();
                        userToComplete.markTaskAsDone(taskComplete);
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 4: // View all tasks for a user
                    System.out.print("Enter username: ");
                    String userForView = scanner.nextLine().trim();
                    User userToView = findUser(users, userForView, userCount);
                    if (userToView != null) {
                        userToView.seeAllTasks();
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                case 5: // Exit the program
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // method to find a user by username
    private static User findUser(User[] users, String username, int userCount) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username.trim())) {
                return users[i];
            }
        }
        return null;
    }
}