public class SinglyLinkedList{

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Insertion at head
    public void insertAtHead(int data){
        // TODO
        Node newNode = new Node(data);

        // if LL is Empty -> head and tail ko newNode pr point kardo
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        // Increase the size
        size++;
    }

    // Insertion at tail
    public void insertAtTail(int data){
        // TODO
        Node newNode = new Node(data);

        // if LL is Empty
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        // Increase the size
        size++;
    }

    // Insert at position
    public class inseartAtPosition(int data){
        
    }

}

