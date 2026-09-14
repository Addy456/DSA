public class CircularDoublyLinkedList {
    
    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    CircularDoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

}
