package linkedList.singlylinkList;

public class main {
    public static void main(String[] args) {
        singliLinkedList sl = new singliLinkedList();
        sl.addElementAtEnd(45);
        sl.addElementAtBeggining(54);
        sl.addElementAtEnd(10);
        sl.addElementAtEnd(20);
        sl.addElementAtEnd(30);
        sl.addElementInBetween(40,sl.head.getNext());
        sl.printLinkedList();
        sl.deleteAtBeggining();
        sl.printLinkedList();
        sl.deleteElement(10);
        sl.printLinkedList();
        sl.deleteAtPosition(5);
        sl.printLinkedList();
        System.out.println(sl.getLength());
        sl.deleteLinkedList();
        sl.printLinkedList();
    }
}
