package Stack;

public class StackUsingLinkedList {
    private Node top;
    private int size;

    public static void main(String[] args) {
        StackUsingLinkedList sl = new StackUsingLinkedList();
        sl.pop();
//        System.out.println(sl.peek());
        sl.push(10);
        sl.push(20);
        sl.push(30);
        sl.peek();
        sl.pop();
        sl.printStack();
        System.out.println(sl.size);
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node new_node = new Node(data);
        if (isEmpty()) {
            top = new_node;
            size++;
            System.out.println("inserted: " + data);
            return;
        }
        new_node.next = top;
        top = new_node;
        size++;
        System.out.println("inserted: " + data);
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }
        System.out.println("Poped Element: " + top.data);
        top = top.next;
        size--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
//            System.exit(-1);
            return;
        }
        System.out.println(top.data);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
//            System.exit(-1);
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
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
