public class CircularSinglyLinkedList{
    
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


    public CircularSinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //=============================
    //Insertion
    //=============================

    //insert at head
    public void insertAtHead(int data){

        Node newNode = new Node(data);
        
        //case 1: Empty CSLL
        if(head == null){
            head = tail = newNode;

            // circular connection
            tail.next = head;
        }

        //case 2: Non Empty CSLL
        newNode.next = head;
        head = newNode;

        // circular connection
        tail.next = head;

        // update size
        size++;
    }

    //insert at tail
    public void insertAtTail(int data){
        Node newNode = new Node(data);

        //case 1: Empty CSLL
        if(tail == null){
            head = newNode;
            tail = newNode;

            // circular connection
            tail.next = head;
        }
        // case 2: Non empty CSLL
        tail.next = newNode;
        newNode = tail;

        // circular connection
        tail.next = head;

        // update size
        size++;
    }

    //insert at position
    public void insertAtPosition(int position, int data){

        // case 1: positions are invalid
        if(position < 1 || position > size ){
            System.out.println("position is invalid");
            return;
        }

        // case 2: position is 1
        if(position == 1){
            insertAtHead(data);
        }

        // case 3: position is size
        if(position == size){
            insertAtTail(data);
        }

        // case 4: position is in middle
        Node temp = head;

        for

    }
}