import java.util.Scanner;

public class PerformanceManager {

    // Linear Search Performance
    public void linearSearchPerformance(int[] data, int target) {

        int steps = 0;

        long startTime = System.nanoTime();

        boolean found = false;

        for (int i = 0; i < data.length; i++) {

            steps++;

            if (data[i] == target) {
                found = true;
                break;
            }
        }

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("\nLinear Search");
        System.out.println("--------------------------");
        System.out.println("Target: " + target);
        System.out.println("Found: " + found);
        System.out.println("Steps: " + steps);
        System.out.println(
            "Execution Time: " +
            executionTime +
            " nanoseconds"
        );
        System.out.println("Time Complexity: O(n)");
    }

    // Binary Search Performance
    public void binarySearchPerformance(int[] data, int target) {

        int steps = 0;

        int left = 0;
        int right = data.length - 1;

        boolean found = false;

        long startTime = System.nanoTime();

        while (left <= right) {

            steps++;

            int middle = (left + right) / 2;

            if (data[middle] == target) {

                found = true;
                break;

            } else if (data[middle] < target) {

                left = middle + 1;

            } else {

                right = middle - 1;
            }
        }

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("\nBinary Search");
        System.out.println("--------------------------");
        System.out.println("Target: " + target);
        System.out.println("Found: " + found);
        System.out.println("Steps: " + steps);
        System.out.println(
            "Execution Time: " +
            executionTime +
            " nanoseconds"
        );
        System.out.println("Time Complexity: O(log n)");
    }

    // Comparison
    public void compare(int target) {

        // Sorted data for fair Binary Search
        int[] data = {
            10, 20, 30, 40, 50,
            60, 70, 80, 90, 100
        };

        System.out.println("\n=================================");
        System.out.println("      PERFORMANCE COMPARISON");
        System.out.println("=================================");

        System.out.print("Data: ");

        for (int value : data) {
            System.out.print(value + " ");
        }

        System.out.println();

        linearSearchPerformance(data, target);

        binarySearchPerformance(data, target);

        System.out.println("\n=================================");
        System.out.println("COMPLEXITY COMPARISON");
        System.out.println("=================================");
        System.out.println(
            "Linear Search : O(n)"
        );
        System.out.println(
            "Binary Search : O(log n)"
        );

        System.out.println(
            "\nBinary Search generally requires fewer"
        );

        System.out.println(
            "steps when searching sorted data."
        );
    }

    // Menu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     PERFORMANCE OPERATIONS");
            System.out.println("=================================");
            System.out.println("1. Compare Searching");
            System.out.println("2. Return to Main Menu");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                        "Enter value to search: "
                    );

                    int target = scanner.nextInt();

                    compare(target);

                    break;

                case 2:

                    System.out.println(
                        "Returning to Main Menu..."
                    );

                    break;

                default:

                    System.out.println(
                        "Invalid choice."
                    );
            }

        } while (choice != 2);
    }
}