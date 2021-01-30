package linkedList;

public class SinglyLinkedList {
    Node head;

    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertAtEnd(10);
        sl.addElementInBetween(15, sl.head);
        sl.insertAtEnd(20);
        sl.addElementAtBeggining(5);
        sl.printList();
        sl.deleteAtPosition(1);
        sl.insertAtEnd(25);
        sl.printList();
        sl.deleteElement(25);
        sl.printList();
        sl.deleteAtBeggining();
        sl.printList();
        sl.getLength();
    }

    public void addElementAtBeggining(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new_node;
    }

    public void addElementInBetween(int data, Node after_value) {
        if (after_value == null) {
            System.out.println("'after node' value can't be null");
            return;
        }
        Node new_node = new Node(data);
        new_node.next = after_value.next;
        after_value.next = new_node;
    }

    public void printList() {
        if (head == null) {
            System.out.println("No element found");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count = count + 1;
            temp = temp.next;
        }
        return count;
    }

    public void deleteLinkedList() {
        head = null;
        System.out.println("list has been deleted");
    }

    public void deleteElement(int data) {
        Node temp = head;
        Node prev = null;
        if (head == null) {
            System.out.println("Sorry no element in the list");
            return;
        }
        // if node is head node
        if (head.data == data) {
            head = head.next;
            return;
        }
        while (temp != null) {
            if (data == temp.data) {
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("no element found");
            return;
        }
        if (position > getLength()) {
            System.out.println("invalid position");
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        int count = 0;
        Node prev = head;
        while (count == position || temp.next != null) {
            if (count == position) {
                prev.next = temp.next;
                return;
            }
            count = count + 1;
            prev = temp;
            temp = temp.next;
        }
    }

    public void deleteAtBeggining() {
        if (head == null) {
            System.out.println(" Sorry no element in the list");
            return;
        }
        head = head.next;
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
