import java.util.Scanner;

public class QueueManager {

    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueManager(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void enqueue(int value) {

        if (size == queue.length) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println("Value enqueued successfully.");
    }

    // Dequeue
    public void dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int value = queue[front];

        front = (front + 1) % queue.length;
        size--;

        System.out.println("Dequeued value: " + value);
    }

    // Peek / Front
    public void peek() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Front value: " + queue[front]);
    }

    // Display
    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.println(queue[index]);
        }
    }

    // Queue Menu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("        QUEUE OPERATIONS");
            System.out.println("=================================");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}