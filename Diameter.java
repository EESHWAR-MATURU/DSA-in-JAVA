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

    void Inorder(Treenode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }
    int Height(Treenode node){
        if(node==null){
            return 0;
        }
        return Math.max(Height(node.left), Height(node.right))+1;
    }
    int Diameter(Treenode node){
        if(node==null){
            return 0;
        }
        int leftHeight=Height(node.left);
        int rightHeight=Height(node.right);
        int currentDiameter=leftHeight+rightHeight;
        int leftDiameter=Diameter(node.left);
        int rightDiameter=Diameter(node.right);
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
}
}
class Diameter {
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
        root.Diameter(root);
        sc.close();
    }
}