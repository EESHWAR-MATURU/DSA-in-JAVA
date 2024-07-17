import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

class LinkedList {
    Node head = null;

    void insert(int n) {
        Node a = new Node(n);
        if (head == null) {
            head = a;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = a;
        }
    }

    void display() {
        Node temp = head;
        if (head == null) {
            return;
        } else {
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    void deletebegin() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
    }
}

public class Linked {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n;

        while (sc.hasNextInt()) {
            n = sc.nextInt();
            if (n == -1) {
                break;
            } else {
                ll.insert(n);
            }
        }
        
        ll.deletebegin();
        ll.display();
        sc.close();
    }
}
