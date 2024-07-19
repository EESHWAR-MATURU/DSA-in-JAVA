import java.util.Scanner;
class Adjacency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of nodes in the graph");
        int nodes = sc.nextInt();
        System.out.println("Please enter the number of edges in the graph");
        int edges = sc.nextInt();
        int[][] adjacencyMatrix = new int[nodes][nodes];
        System.out.println("Is the graph directed");
        boolean directed = sc.next().equalsIgnoreCase("yes");
        System.out.println("Adjacency Matrix Representation:");
        printMatrix(adjacencyMatrix, nodes);
        for (int i = 0; i < edges; i++) {
            System.out.printf("Enter the start node, end node and weight of edge no %d%n", i + 1);
            int startNode = sc.nextInt() - 1;
            int endNode = sc.nextInt() - 1;
            int weight = sc.nextInt();
            adjacencyMatrix[startNode][endNode] = weight;
            if (!directed) {
                adjacencyMatrix[endNode][startNode] = weight;
            }
        }
        System.out.println("Adjacency Matrix Representation:");
        printMatrix(adjacencyMatrix, nodes);
        sc.close();
    }
    static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}