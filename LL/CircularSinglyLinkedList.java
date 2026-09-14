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
        else{
            newNode.next = head;
            head = newNode;

            // circular connection
            tail.next = head;
        }

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
        else{
            tail.next = newNode;
            tail = newNode;

            // circular connection
            tail.next = head;
        }

        // update size
        size++;
    }

    //insert at position
    public void insertAtPosition(int position, int data){

        // case 1: positions are invalid
        if(position < 1 || position > size + 1){
            System.out.println("position is invalid");
            return;
        }

        // case 2: position is 1
        if(position == 1){
            insertAtHead(data);
            return;
        }

        // case 3: position is size
        if(position == size + 1){
            insertAtTail(data);
            return;
        }

        // case 4: position is in middle
        Node prevNode = head;

        for(int i=1; i <= position-2; i++){
            prevNode = prevNode.next;
        }

        Node nextNode = prevNode.next;

        Node newNode = new Node(data);

        prevNode.next = newNode;
        newNode.next = nextNode;

        // update size
        size++;   
    }

    //========================
    //Utility functions
    //========================

    public void printList(){
        // case 1: Empty CSLL
        if(head == null){
            System.out.println("Empty linked list");
            return;
        }

        Node temp = head;

        //printing CSLL
        do{
            System.out.print(temp.data+"->");
            temp = temp.next;
        }while(temp!=head);

        System.out.println("Back to Head");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getHead(){
        if(head == null){
            throw new IllegalStateException(
                "Circular Linked List is empty"
            );
        }
        return head.data;
    }

    public int getTail(){
        if(tail == null){
            throw new IllegalStateException(
                "Circular Linkedc List is empty"
            );
        }
        return tail.data;
    }

    //========================
    //Searching
    //========================
    
    public boolean search(int target){
        
        if(head == null){
            return false;
        }

        Node temp = head;

        do{
            if(temp.data == target){
                return true;
            }
            else{
                temp = temp.next;
            }
        }while(temp!=head);
        
        return false;
    }

    public void deleteAtHead(){
        if(head == null){
            System.out.println("Empty CSLL No Deletion possible");
            return;
        }

        if(head == tail){
            head.next = null;
            head = null;
            tail = null;

            // update size
            size=0;
            return;
        }

        tail.next = head.next;
        head.next = null;
        head = tail.next;
        
        // update size 
        size--;
    }

    public void deleteAtTail(){

        if(tail == null){
            System.out.println("Empty Linked list");
            return;
        }

        if(head == tail){
            head = tail = null;
            size = 0;
            return;
        }

        Node temp = head;

        for(int i=1;i < size-1; i++){
            temp = temp.next;
        }
        tail = temp;
        tail.next = head;

        // update size
        size--;
    }

    public void deleteAtPosition(int position){
        if(position < 1 || position > size + 1){
            System.out.println("Invalid position deletion not possible");
            return;
        }

        if(position == 1){
            deleteAtHead();
            return;
        }

        if(position == size){
            deleteAtTail();
            return;
        }

        Node prevNode = head;

        for(int i=1; i<position-1; i++){
            prevNode = prevNode.next;
        }

        Node currNode = prevNode.next;
        Node nextNode = currNode.next;

        prevNode.next = nextNode;
        currNode.next = null;

        // update size
        size--;
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

        System.out.println(mylist.getSize());

        mylist.insertAtPosition(10,1001);
        mylist.printList();

        mylist.insertAtPosition(5,0);
        mylist.printList();

        mylist.insertAtPosition(13,0);
        mylist.printList();

        System.out.println("Found or not: "+mylist.search(0));

        System.out.println("Found or not: "+mylist.search(-1));

        mylist.deleteAtHead();
        mylist.printList();

        mylist.deleteAtPosition(5);
        mylist.printList();

        mylist.deleteAtTail();
        mylist.printList();

    }
}