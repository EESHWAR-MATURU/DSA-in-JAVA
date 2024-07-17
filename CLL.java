import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
}
class CLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node temp = null;
        int val;
        val = sc.nextInt();
        head = new Node(val);
        temp = head;
        int choice;
        while (true) {
            choice = sc.nextInt();
            if (choice == 0) {
                break;
            } 
            else if (choice == 1) {
                val = sc.nextInt();
                Node a = new Node(val);
                temp.next = a;
                temp = a;
            }
        }
        temp.next = head;
        temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        sc.close();
    }
}