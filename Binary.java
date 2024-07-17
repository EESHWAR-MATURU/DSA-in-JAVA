import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Treenode {
    int data;
    Treenode left, right;

    Treenode(int val) {
        data = val;
        left = right = null;
    }
    void Preorder(Treenode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        Preorder(root.left);
        Preorder(root.right);
    }
}
class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Treenode root = new Treenode(n);
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Treenode root1 = q.poll();
            int lv = sc.nextInt();
            if (lv != -1) {
                root1.left = new Treenode(lv);
                q.add(root1.left);
            }
            int rv = sc.nextInt();
            if (rv != -1) {
                root1.right = new Treenode(rv);
                q.add(root1.right);
            }
        }
        root.Preorder(root);
        sc.close();
    }
}