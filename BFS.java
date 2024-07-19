import java.util.*;

class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of vertices
        int vertices = sc.nextInt();

        if (vertices == 0) {
            System.out.println("Graph doesn't exist");
            return;
        }

        // Initialize the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read edges until -1 -1 is encountered
        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (u == -1 && v == -1) {
                break;
            }
            adjList.get(u).add(v);
        }

        // Perform BFS starting from vertex 0
        System.out.print("BFS : ");
        bfsTraversal(0, vertices, adjList);
    }

    private static void bfsTraversal(int start, int vertices, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
