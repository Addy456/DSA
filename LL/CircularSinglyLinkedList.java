import java.net.SocketPermission;

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

    //=====================================
    //Print circular singly linked list
    //=====================================

    public void printList(){
        // case 1: Empty CSLL
        if(head == null){
            System.out.println("Empty linked list");
            return;
        }

        Node temp = head;

        //printing CSLL
        do{
            System.out.print(temp+"->");
            temp = temp.next;
        }while(temp!=head);

        System.out.println("Back to Head");
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

    public static void main(String[] args) {
        CircularSinglyLinkedList mylist = new CircularSinglyLinkedList();

        mylist.insertAtHead(10);
        mylist.printList();
        
    }
}