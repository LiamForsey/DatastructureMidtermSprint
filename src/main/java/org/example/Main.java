package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[15];
        int userCount = 0;

        while (true) {
            // Print Menu
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // This adds a new user
            switch (choice) {
                case 1:
                    if (userCount >= users.length) {
                        System.out.println("User limit reached!");
                        break;
                    }
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    users[userCount++] = new User(username);
                    System.out.println("User added successfully!");
                    break;

                    // This will add a task to the list
                case 2:
                    System.out.print("Enter username: ");
                    String userForTask = scanner.nextLine();
                    User selectedUser = findUser(users, userForTask, userCount);
                    if (selectedUser != null) {
                        System.out.print("Enter task description: ");
                        String taskDesc = scanner.nextLine();
                        selectedUser.addTask(taskDesc);
                        System.out.println("Task added successfully!");
                    } else {
                        System.out.println("User not found!");
                    }
                    break;

                    // This code will mark if its done
                case 3:
                    System.out.print("Enter username: ");
                    String userForCompletion = scanner.nextLine();
                    User userToComplete = findUser(users, userForCompletion, userCount);
                    if (userToComplete != null) {
                        System.out.print("Enter task description to mark as completed: ");
                        String taskComplete = scanner.nextLine();
                        userToComplete.markTaskAsDone(taskComplete);
                    } else {
                        System.out.println("User not found!");
                    }
                    break;


                    // This is how you view all tasks for a user
                case 4:
                    System.out.print("Enter username: ");
                    String userForView = scanner.nextLine();
                    User userToView = findUser(users, userForView, userCount);
                    if (userToView != null) {
                        userToView.seeAllTasks();
                    } else {
                        System.out.println("User not found!");
                    }
                    break;


                    // Exiting Program:
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }


    private static User findUser(User[] users, String username, int userCount) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username)) {
                return users[i];
            }
        }
        return null;
    }
}