import java.util.*;

public class GraphManager {

    private Map<Integer, List<Integer>> graph;

    public GraphManager() {
        graph = new HashMap<>();
    }

    // Add Vertex
    public void addVertex(int vertex) {

        if (graph.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return;
        }

        graph.put(vertex, new ArrayList<>());

        System.out.println("Vertex added successfully.");
    }

    // Add Edge
    public void addEdge(int vertex1, int vertex2) {

        if (!graph.containsKey(vertex1) ||
            !graph.containsKey(vertex2)) {

            System.out.println(
                "Both vertices must exist first."
            );
            return;
        }

        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);

        System.out.println("Edge added successfully.");
    }

    // Display Graph
    public void displayGraph() {

        if (graph.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph:");

        for (int vertex : graph.keySet()) {

            System.out.print(vertex + " -> ");

            for (int neighbour : graph.get(vertex)) {
                System.out.print(neighbour + " ");
            }

            System.out.println();
        }
    }

    // BFS
    public void bfs(int startVertex) {

        if (!graph.containsKey(startVertex)) {
            System.out.println("Vertex not found.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbour : graph.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // DFS
    public void dfs(int startVertex) {

        if (!graph.containsKey(startVertex)) {
            System.out.println("Vertex not found.");
            return;
        }

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(startVertex, visited);

        System.out.println();
    }

    private void dfsRecursive(
            int vertex,
            Set<Integer> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (int neighbour : graph.get(vertex)) {

            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }

    // Graph Menu
    public void menu(Scanner scanner) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("        GRAPH OPERATIONS");
            System.out.println("=================================");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter vertex: ");
                    int vertex = scanner.nextInt();
                    addVertex(vertex);
                    break;

                case 2:
                    System.out.print("Enter first vertex: ");
                    int vertex1 = scanner.nextInt();

                    System.out.print("Enter second vertex: ");
                    int vertex2 = scanner.nextInt();

                    addEdge(vertex1, vertex2);
                    break;

                case 3:
                    displayGraph();
                    break;

                case 4:
                    System.out.print(
                        "Enter starting vertex: "
                    );

                    int bfsStart = scanner.nextInt();

                    bfs(bfsStart);
                    break;

                case 5:
                    System.out.print(
                        "Enter starting vertex: "
                    );

                    int dfsStart = scanner.nextInt();

                    dfs(dfsStart);
                    break;

                case 6:
                    System.out.println(
                        "Returning to Main Menu..."
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice."
                    );
            }

        } while (choice != 6);
    }
}