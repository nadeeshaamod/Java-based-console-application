import java.util.Scanner;

public class LinkedListManager {

    // Node class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedListManager() {
        head = null;
    }

    // Insert
    public void insert(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Value inserted successfully.");
    }

    // Delete
    public void delete(int value) {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        // Delete first node
        if (head.data == value) {
            head = head.next;
            System.out.println("Value deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != value) {

            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }

        current.next = current.next.next;

        System.out.println("Value deleted successfully.");
    }

    // Search
    public void search(int value) {

        Node current = head;
        int position = 0;

        while (current != null) {

            if (current.data == value) {
                System.out.println(
                    "Value found at position: " + position
                );
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found.");
    }

    // Display
    public void display() {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node current = head;

        System.out.println("Linked List:");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println(" -> NULL");
    }

    // Menu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("      LINKED LIST OPERATIONS");
            System.out.println("=================================");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int insertValue = scanner.nextInt();
                    insert(insertValue);
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    delete(deleteValue);
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    search(searchValue);
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println(
                        "Returning to Main Menu..."
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}