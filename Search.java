import java.util.*;

public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree bst = new Tree();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val < 0)
                break;
            bst.root = bst.insert(bst.root, val);
        }
        int key = sc.nextInt();
        System.out.println(bst.search(bst.root, key));
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
        } else if (val < curr.data)
            curr.left = insert(curr.left, val);
        else if (val > curr.data)
            curr.right = insert(curr.right, val);
        return curr;
    }

    public boolean search(Node curr, int key) {
        if (curr == null)
            return false;
        else if (curr.data == key)
            return true;
        else if (curr.data > key)
            return search(curr.left, key);
        else
            return search(curr.right, key);
    }
}