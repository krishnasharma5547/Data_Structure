package linkedList.singlylinkList;

public class singliLinkedList {
    Node head;

    public void addElementAtBeggining(int data) {
        Node new_node = new Node(data);
        new_node.setNext(head);
        head = new_node;
    }

    public void addElementAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(new_node);
        return;
    }

    public void addElementInBetween(int data, Node after_value){
        if (after_value == null){
            System.out.println("'after node' value can't be null");
            return;
        }
        Node new_node = new Node(data);
        new_node.setNext(after_value.getNext());
        after_value.setNext(new_node);
    }

    public void deleteAtBeggining(){
        if (head == null){
            System.out.println(" Sorry no element in the list");
            return;
        }
        head = head.getNext();
    }

    public void deleteElement(int data){
        Node temp = head;
        Node prev = null;
        if (head == null){
            System.out.println("Sorry no element in the list");
            return;
        }
        // if node is head node
        if (head.getData() == data){
            head = head.getNext();
            return;
        }
        while (temp != null){
            if (data == temp.getData()){
                prev.setNext(temp.getNext());
            }
            prev = temp;
            temp = temp.getNext();
        }

    }

    public void deleteAtPosition(int position){
        if (head == null){
            System.out.println("no element found");
            return;
        }
        if (position > getLength()){
            System.out.println("invalid position");
            return;
        }
        if (position == 0){
            head = head.getNext();
            return;
        }
        Node temp = head;
        int count = 0;
        Node prev = head;
        while (count == position || temp.getNext()!=null){
            if (count == position){
                prev.setNext(temp.getNext());
                return;
            }
            count = count+1;
            prev = temp;
            temp = temp.getNext();
        }
    }

    public int getLength(){
        Node temp = head;
        int count = 0;
        while(temp !=null){
            count = count + 1;
            temp = temp.getNext();
        }
        return count;
    }

    public void deleteLinkedList(){
        head = null;
        System.out.println("list has been deleted");
    }

    public void printLinkedList(){
        if(head == null){
            System.out.println("No element found");
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
