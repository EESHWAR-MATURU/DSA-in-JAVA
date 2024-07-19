import java.util.*;

class DFS {
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

        // Perform DFS starting from vertex 0
        System.out.print("DFS : ");
        boolean[] visited = new boolean[vertices];
        dfsTraversal(0, adjList, visited);
    }

    private static void dfsTraversal(int current, List<List<Integer>> adjList, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                System.out.print(node + " ");
                visited[node] = true;

                // Push all unvisited neighbors onto the stack
                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
