import java.util.Scanner;

public class StackManager {

    private int[] stack;
    private int top;

    public StackManager(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    // Push
    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        top++;
        stack[top] = value;

        System.out.println("Value pushed successfully.");
    }

    // Pop
    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }

        int value = stack[top];
        top--;

        System.out.println("Popped value: " + value);
    }

    // Peek
    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top value: " + stack[top]);
    }

    // Display
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements:");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // Stack Menu
    public void menu(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("        STACK OPERATIONS");
            System.out.println("=================================");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
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