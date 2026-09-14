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

    
    //===================
    //Insertion
    //===================

    //Insert at head
    public void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            
            tail.next = head;
            head.prev = tail;
        }
        else{
            newNode.next = head;
            head.prev = newNode;

            newNode.prev = tail;
            tail.next = newNode;

            head = newNode;
        }
        // update size
        size++;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = tail = newNode;

            tail.next = head;
            head.prev = tail;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;

            newNode.next = head;
            head.prev = newNode;

            tail = newNode;
        }

        // update size
        size++;
    }
    
    public void insertAtPosition(int position, int data){
        if(position < 1 || position > size + 1){
            System.out.println("Positions are invalid");
            return;
        }

        if(position == 1){
            insertAtHead(data);
            size++;
        }

        if(position == size+1){
            insertAtTail(data);
            size++;
        }

        Node prevNode = head;

        for(int i = 1; i < position-1; i++){
            prevNode = prevNode.next;
        }

        Node newNode = new Node(data);
        Node nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.next = nextNode;
        
        nextNode.prev = newNode;
        newNode.prev = prevNode;

        // update size
        size++;
    }

     public static void main(String[] args) {
        CircularSinglyLinkedList mylist = new CircularSinglyLinkedList();

        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(30);
        mylist.printList();

        mylist.insertAtHead(40);
        mylist.printList();

        mylist.insertAtTail(100);
        mylist.printList();

        mylist.insertAtTail(110);
        mylist.printList();

        mylist.insertAtTail(120);
        mylist.printList();

        mylist.insertAtTail(130);
        mylist.printList();

        mylist.insertAtPosition(1,1000);
        mylist.printList();

        mylist.insertAtPosition(10,1001);
        mylist.printList();

        mylist.insertAtPosition(5,0);
        mylist.printList();

    }
}
