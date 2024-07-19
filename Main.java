import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Define the Node class
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Define the BST class
public class Main {
    Node root;

    Main() {
        root = null;
    }

    // Insert a new key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }

    // This method mainly calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // A recursive function to delete a key from BST
    Node deleteRec(Node root, int key) {
        // Base case: if the tree is empty
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

        // If the key is the same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // This method mainly calls sumOfNodesRec()
    int sumOfNodes() {
        return sumOfNodesRec(root);
    }

    // A recursive function to calculate the sum of all nodes in BST
    int sumOfNodesRec(Node root) {
        if (root == null)
            return 0;
        return root.key + sumOfNodesRec(root.left) + sumOfNodesRec(root.right);
    }

    // This method mainly calls inorderRec()
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // This method mainly calls preorderRec()
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    // A utility function to do preorder traversal of BST
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // This method mainly calls postorderRec()
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // A utility function to do postorder traversal of BST
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Search for a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search a key in the BST
    boolean searchRec(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key)
            return root != null;

        // Key is greater than root's key
        if (root.key < key)
            return searchRec(root.right, key);

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Calculate the diameter of the tree
    int diameter() {
        return diameterRec(root);
    }

    // A utility function to calculate the diameter of the tree
    int diameterRec(Node root) {
        if (root == null)
            return 0;

        // Get the height of left and right sub-trees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Get the diameter of left and right sub-trees
        int leftDiameter = diameterRec(root.left);
        int rightDiameter = diameterRec(root.right);

        // Return max of the following three
        // 1) Diameter of left subtree
        // 2) Diameter of right subtree
        // 3) Height of left subtree + height of right subtree + 1
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    // A utility function to calculate the height of a tree
    int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Build the tree level by level using user input
    void buildTreeLevelOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root value: ");
        int rootValue = sc.nextInt();
        if (rootValue == -1)
            return;

        root = new Node(rootValue);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print("Enter left child of " + current.key + " (or -1 for no child): ");
            int leftValue = sc.nextInt();
            if (leftValue != -1) {
                current.left = new Node(leftValue);
                q.add(current.left);
            }

            System.out.print("Enter right child of " + current.key + " (or -1 for no child): ");
            int rightValue = sc.nextInt();
            if (rightValue != -1) {
                current.right = new Node(rightValue);
                q.add(current.right);
            }
        }
    }

    // Driver code to test above
    public static void main(String[] args) {
        Main tree = new Main();
        Scanner scanner = new Scanner(System.in);
        int choice, key;

        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Sum of Nodes");
            System.out.println("7. Search");
            System.out.println("8. Diameter");
            System.out.println("9. Build Tree Level Order");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    key = scanner.nextInt();
                    tree.insert(key);
                    break;
                case 2:
                    System.out.print("Enter key to delete: ");
                    key = scanner.nextInt();
                    tree.deleteKey(key);
                    break;
                case 3:
                    System.out.println("Inorder traversal:");
                    tree.inorder();
                    break;
                case 4:
                    System.out.println("Preorder traversal:");
                    tree.preorder();
                    break;
                case 5:
                    System.out.println("Postorder traversal:");
                    tree.postorder();
                    break;
                case 6:
                    System.out.println("Sum of all nodes: " + tree.sumOfNodes());
                    break;
                case 7:
                    System.out.print("Enter key to search: ");
                    key = scanner.nextInt();
                    if (tree.search(key))
                        System.out.println("Key found in the BST.");
                    else
                        System.out.println("Key not found in the BST.");
                    break;
                case 8:
                    System.out.println("Diameter of the tree: " + tree.diameter());
                    break;
                case 9:
                    System.out.println("Building tree using level order input:");
                    tree.buildTreeLevelOrder();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}