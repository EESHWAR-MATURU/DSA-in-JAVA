import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class LeftAndRight {

    public static void rightView(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode current = q.poll();
                if (i == size) {
                    System.out.print(current.data + " ");
                }
                // ADD LEFT NODE
                if (current.left != null)
                    q.add(current.left);
                // ADD RIGHT NODE
                if (current.right != null)
                    q.add(current.right);

            }
        }
    }

    public static void leftView(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode current = q.poll();
                if (i == 1) {
                    System.out.print(current.data + " ");
                    i = 1;
                }
                // ADD LEFT NODE
                if (current.left != null)
                    q.add(current.left);
                // ADD RIGHT NODE
                if (current.right != null)
                    q.add(current.right);

            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        TreeNode root = new TreeNode(r);
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            TreeNode root1 = q1.poll();
            int left = sc.nextInt();
            if (left != -1) {
                root1.left = new TreeNode(left);
                q1.add(root1.left);
            }
            int right = sc.nextInt();
            if (right != -1) {
                root1.right = new TreeNode(right);
                q1.add(root1.right);
            }
        }
        rightView(root);
        leftView(root);
    }
}