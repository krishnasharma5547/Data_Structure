package linkedList;

public class DoublyLinkedList {
    Node head;

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insertAtEnd(10);
        dl.insertAtEnd(20);
        dl.insertAtEnd(30);
        dl.insertAtEnd(40);
        dl.insertAtBeggining(5);
        dl.insertAfterNode(15, dl.head.next);
        dl.deleteAtEnd();
        dl.deleteAtBeggning();
        dl.deleteAfter(dl.head);
        dl.printList();
    }

    public void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            Node pre = temp;
            temp = temp.next;
        }
        new_node.pre = temp;
        temp.next = new_node;
    }

    public void insertAtBeggining(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head.pre = new_node;
        head = new_node;
    }

    public void insertAfterNode(int data, Node node) {
        Node new_node = new Node(data);
        if (node == null) {
            System.out.println("value can't null");
            return;
        }
        Node temp = head;
        new_node.pre = node;
        new_node.next = node.next;
        node.next = new_node;
        if (head.next != null) {
            new_node.next.pre = new_node;
        }
    }

    public void deleteAtBeggning() {
        if (head == null) {
            System.out.println("list is Empty");
            return;
        }
        head = head.next;
        head.pre = null;
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("list is Empty");
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    public void deleteAfter(Node node) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (node == null) {
            System.out.println("value can't be null");
            return;
        }
        if (node.next == null) {
            node.pre.next = null;
            return;
        }
        node.next.next.pre = node;
        node.next = node.next.next;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
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
