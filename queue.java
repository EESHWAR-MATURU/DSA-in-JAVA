import java.util.*;

class Queue {
    int front, rear, size;
    int arr[];

    Queue(int n) {
        arr = new int[n];
        this.size = n;
        this.front = 0;
        this.rear = -1;
    }

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        return rear == size - 1;
    }

    void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        } else {
            arr[++rear] = x;
        }
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        } else {
            front++;
        }
    }

    void reverse() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int temp;
        int start = front;
        int end = rear;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class queue {
    public static void main(String args[]) {
        // Try out your code here
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        Queue q = new Queue(n1);
        for (int i = 0; i < n1; i++) {
            int x1 = sc.nextInt();
            q.enqueue(x1);
        }
        q.reverse();
        q.display();
        sc.close();
    }
}
