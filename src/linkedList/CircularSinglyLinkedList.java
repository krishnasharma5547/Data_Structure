package linkedList;

public class CircularSinglyLinkedList {
    Node head;
    Node last;
    int size = 0;

    public static void main(String[] args) {
        CircularSinglyLinkedList csl = new CircularSinglyLinkedList();
        csl.insertAtEnd(10);
        csl.insertAtEnd(20);
        csl.insertAtEnd(30);
        csl.insertAtBeggining(5);
        csl.insertAfter(15, csl.head.next);
        csl.insertAfter(35, csl.last);
        csl.deleteAtBeggining();
        csl.deleteAtEnd();
        csl.delete(csl.head);
        csl.printList();
        System.out.println(csl.size);
    }

    public void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            last = head;
            size++;
            return;
        }
        last.next = new_node;
        new_node.next = head;
        last = new_node;
        size++;
    }

    public void insertAtBeggining(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            size++;
            return;
        }
        new_node.next = head;
        head = new_node;
        last.next = new_node;
        size++;
    }

    public void insertAfter(int data, Node node) {
        Node new_node = new Node(data);
        if (node == null) {
            System.out.println("plaase prove a valid after value!");
        }
        if (head == null) {
            head = new_node;
            last = new_node;
            size++;
            return;
        }
        Node temp = head;
        while (temp != node) {
            temp = temp.next;
        }
        if (temp.next == head) {
            temp.next = new_node;
            new_node.next = head;
            last = new_node;
            size++;
            return;
        }
        new_node.next = temp.next;
        temp.next = new_node;
        size++;
    }

    public void deleteAtBeggining() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        head = head.next;
        last.next = head;
        size--;
    }

    public void deleteAtEnd() {
        if (head == last) {
            head = null;
            last = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != last) {
            temp = temp.next;
        }
        temp.next = head;
        last = temp;
        size--;
    }

    public void delete(Node node) {
        if (node == null) {
            System.out.println("Node cant be null");
        }
        if (node == head) {
            head = head.next;
            last.next = head;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != node) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        if (node.next == head) {
            last = temp;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println(temp.data + "-->");
    }

    static class Node {
        private Node next;
        private int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
