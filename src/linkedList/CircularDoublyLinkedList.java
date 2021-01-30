package linkedList;

public class CircularDoublyLinkedList {
    Node head;
    Node last;
    int size = 0;

    public static void main(String[] args) {
        CircularDoublyLinkedList cdl = new CircularDoublyLinkedList();
//        cdl.insertAtEnd(5);
        cdl.insertAtBegging(30);
        cdl.insertAtBegging(20);
        cdl.insertAtBegging(10);
        cdl.insertAfter(15, cdl.head);
        cdl.insertAtEnd(40);
        cdl.deleteAtBegging();
        cdl.deleteAtEnd();
        cdl.delete(cdl.head.next);
        cdl.printList();
        cdl.printReverseList();
        System.out.println(cdl.size);
    }

    public boolean isEmpty() {
        if (head == null) {
            System.out.println("List is Empty!");
            return true;
        } else {
            return false;
        }
    }

    public void insertAtBegging(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            last = head;
            size++;
            return;
        }
        new_node.next = head;
        head.pre = new_node;
        new_node.pre = last;
        head = new_node;
        last.next = new_node;
        size++;
    }

    public void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            last = new_node;
            size++;
            return;
        }
        new_node.next = head;
        head.pre = new_node;
        last.next = new_node;
        new_node.pre = last;
        last = new_node;
        size++;
    }

    public void insertAfter(int data, Node node) {
        Node new_node = new Node(data);
        if (node == null) {
            System.out.println("after value can't be empty");
            return;
        }
        Node temp = head;
        while (temp != node) {
            temp = temp.next;
        }
        new_node.pre = temp;
        new_node.next = temp.next;
        if (temp.next == head) {
            temp.next = new_node;
            last = new_node;
            head.pre = new_node;
            size++;
        }
        temp.next.pre = new_node;
        temp.next = new_node;
        size++;
    }

    public void deleteAtBegging() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        head.pre = last;
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty())
            return;
        last.pre.next = head;
        last = last.pre;
        head.pre = last;
        size--;
    }

    public void delete(Node node) {
        if (node == null) {
            System.out.println("After value can't be empty!");
            return;
        }
        if (node == last) {
            head.pre = head.pre.pre;
            node.pre.next = head;
            last = head.pre;
            size--;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void printList() {
        if (isEmpty()) {
            return;
        }
        Node temp = head;
        while (temp != last) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public void printReverseList() {
        if (isEmpty()) {
            return;
        }
        Node temp = last;
        while (temp != head) {
            System.out.print(temp.data + "-->");
            temp = temp.pre;
        }
        System.out.println(temp.data);

    }

    static class Node {
        private int data;
        private Node next;
        private Node pre;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }
}
