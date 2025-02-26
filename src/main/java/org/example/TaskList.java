package org.example;

public class TaskList {
    private Node head;


    private class Node {
        Task task;
        Node next;


        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }


    public TaskList() {
        head = null;
    }


    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public void markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equalsIgnoreCase(description)) {
                current.task.markAsCompleted();
                System.out.println("Task '" + description + "' marked as completed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + description);
    }


    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
