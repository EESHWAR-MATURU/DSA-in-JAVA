import java.util.*;

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree bst = new Tree();
        // int val= sc.nextInt();
        while (true) {
            int val = sc.nextInt();
            if (val < 0)
                break;
            bst.root = bst.insert(bst.root, val);
        }
        bst.inorder(bst.root);
        sc.close();
    }

}

class Tree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root = null;

    public Node insert(Node curr, int val) {
        if (curr == null) {
            Node n = new Node(val);
            return n;
        } else if (val < curr.data) {
            curr.left = insert(curr.left, val);
        } else if (val > curr.data) {
            curr.right = insert(curr.right, val);
        }
        return curr;
    }

    public void inorder(Node curr) {
        if (curr == null)
            return;
        // ascending order
        // inorder(root.left);
        // System.out.println(root.data+" ");
        // inorder(root.right);

        // descending order
        inorder(curr.right);
        System.out.println(curr.data + " ");
        inorder(curr.left);

    }
}