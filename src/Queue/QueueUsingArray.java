package Queue;

public class QueueUsingArray {
    private int front;
    private int rare;
    private int size;
    private int[] arr;
    private int capacity;

    QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.rare = -1;
        this.front = 0;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public static void main(String[] args) {
        QueueUsingArray qa = new QueueUsingArray(5);
        qa.dequeue();
        qa.peek();
        qa.enqueue(10);
        qa.enqueue(20);
        qa.enqueue(25);
        qa.enqueue(30);
        qa.enqueue(40);
        qa.enqueue(50);
        qa.dequeue();
        qa.printQueue();
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        rare = (rare + 1) % capacity;
        arr[rare] = data;
        size++;
        System.out.println(data + "Inserted! ");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! ");
            return;
        }
        System.out.println(arr[front] + "deleted");
        front = (front + 1) % capacity;
        size--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! ");
            return;
        }
        System.out.println(arr[front]);
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! ");
            return;
        }
        int temp = front;
        while (temp != rare) {
            System.out.print(arr[temp] + " ");
            temp = temp + 1;
        }
        System.out.println(arr[temp]);
    }
}
