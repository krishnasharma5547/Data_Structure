package Stack;

public class StackUsingArray {
    private int[] arr;
    private int top;
    private int capacity;

    StackUsingArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public static void main(String[] args) {
        StackUsingArray sa = new StackUsingArray(4);
        sa.push(10);
        sa.push(20);
        sa.push(30);
        sa.peek();
        sa.push(40);
        sa.push(50);
        sa.pop();
        sa.pop();
        sa.peek();
    }

    public boolean isFull() {
        return top + 1 == capacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println(" OverFlow");
            return;
        }
        arr[++top] = data;
        System.out.println(data + " inserted!");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println(" List is Empty");
            return;
        }
        System.out.println(arr[top] + " Removed!");
        arr[top--] = 0;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println(" Stack is Empty!");
            return;
        }
        System.out.println(arr[top]);
    }
}
