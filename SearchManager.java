import java.util.Scanner;

public class SearchManager {

    private int[] data;
    private int size;

    public SearchManager(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // Add value
    public void add(int value) {

        if (size == data.length) {
            System.out.println("Data is full.");
            return;
        }

        data[size] = value;
        size++;

        System.out.println("Value added successfully.");
    }

    // Display
    public void display() {

        if (size == 0) {
            System.out.println("No data available.");
            return;
        }

        System.out.print("Data: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    // Linear Search
    public void linearSearch(int target) {

        int steps = 0;

        for (int i = 0; i < size; i++) {

            steps++;

            if (data[i] == target) {
                System.out.println("Linear Search: Value found.");
                System.out.println("Index: " + i);
                System.out.println("Steps: " + steps);
                return;
            }
        }

        System.out.println("Linear Search: Value not found.");
        System.out.println("Steps: " + steps);
    }

    // Binary Search
    public void binarySearch(int target) {

        // Sort the data first
        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - i - 1; j++) {

                if (data[j] > data[j + 1]) {

                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        int left = 0;
        int right = size - 1;
        int steps = 0;

        while (left <= right) {

            steps++;

            int middle = (left + right) / 2;

            if (data[middle] == target) {

                System.out.println("Binary Search: Value found.");
                System.out.println("Index: " + middle);
                System.out.println("Steps: " + steps);
                return;
            }

            if (data[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println("Binary Search: Value not found.");
        System.out.println("Steps: " + steps);
    }

    // Menu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("       SEARCHING OPERATIONS");
            System.out.println("=================================");
            System.out.println("1. Add Value");
            System.out.println("2. Display Data");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Return to Main Menu");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    add(value);
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int linearValue = scanner.nextInt();
                    linearSearch(linearValue);
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    int binaryValue = scanner.nextInt();
                    binarySearch(binaryValue);
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