package Queue;

public class QueueUsingLinkedList {
    private Node front;
    private Node rare;
    private int size;

    public static void main(String[] args) {
        QueueUsingLinkedList ql = new QueueUsingLinkedList();
        ql.enqueue(10);
        ql.enqueue(20);
        ql.enqueue(30);
        ql.enqueue(40);
        ql.dequeue();
        ql.dequeue();
        ql.enqueue(50);
        ql.printQueue();
    }

    public void enqueue(int data) {
        Node new_node = new Node(data);
        if (front == null) {
            front = new_node;
            rare = new_node;
            size++;
            return;
        }
        rare.next = new_node;
        rare = new_node;
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty! ");
            return;
        }
        front = front.next;
        if (front == null) {
            rare = null;
        }
    }

    public void printQueue() {
        if (front == null) {
            System.out.println("Queue is Empty! ");
            return;
        }
        Node temp = front;
        while (temp != rare) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
