import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("TEST - APPLICATION STARTED");

        Scanner scanner = new Scanner(System.in);

        ArrayManager arrayManager =
                new ArrayManager(100);

        StackManager stackManager =
                new StackManager(100);

        QueueManager queueManager =
                new QueueManager(100);

        LinkedListManager linkedListManager =
                new LinkedListManager();

        SearchManager searchManager =
                new SearchManager(100);

        GraphManager graphManager =
                new GraphManager();

        PerformanceManager performanceManager =
                new PerformanceManager();

        int choice;

        do {

            System.out.println("\n");
            System.out.println("=============================================");
            System.out.println("       DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.println("=============================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    arrayManager.menu(scanner);
                    break;

                case 2:
                    stackManager.menu(scanner);
                    break;

                case 3:
                    queueManager.menu(scanner);
                    break;

                case 4:
                    linkedListManager.menu(scanner);
                    break;

                case 5:
                    searchManager.menu(scanner);
                    break;

                case 6:
                    graphManager.menu(scanner);
                    break;

                case 7:
                    performanceManager.menu(scanner);
                    break;

                case 8:
                    System.out.println(
                        "\nAll system components are available."
                    );
                    System.out.println(
                        "Use the main menu to test each component."
                    );
                    break;

                case 9:
                    System.out.println(
                        "\nThank you for using the system."
                    );
                    break;

                default:
                    System.out.println(
                        "\nInvalid choice. Please try again."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }
}