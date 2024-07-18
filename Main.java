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
    }

    // A utility function to do postorder traversal of BST
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
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
            System.out.println("7. Exit");
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
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Preorder traversal:");
                    tree.preorder();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Postorder traversal:");
                    tree.postorder();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Sum of all nodes: " + tree.sumOfNodes());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
