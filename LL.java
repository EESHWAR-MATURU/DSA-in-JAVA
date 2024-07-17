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
    
    void rev() {
        Node prev = null;
        Node current = head;
        Node nnext;
        while (current != null) {
            nnext = current.next;
            current.next = prev;
            prev = current;
            current = nnext;
        }
        head = prev;
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

public class LL {
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
        ll.display();
        ll.rev();
        ll.display();
        sc.close();
    }
}
