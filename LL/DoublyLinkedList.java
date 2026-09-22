public class DoublyLinkedList {

    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // data members
    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //===================
    //Insertion
    //===================

    //Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        // when LL is empty
        if(head == null && tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            // head update
            head = newNode;
        }
        //update size
        size++;
    }

     // Insertion at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);

        // when LL is empty
        if (head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            
            // update tail
            tail = newNode;
        }
        // update size
        size++;
    }

    
    // Insert at position
    public void insertAtPosition(int position, int data) {

        // when position is invalid
        if(position < 1 || position > size+1) {
            // insertion not position
            System.out.println("Insertion is not possible at this position");
            return;
        }

        // when position is at head
        if(position == 1) {
            insertAtHead(data);
            return;
        }

        // when position is at tail
        if(position == size+1) {
            insertAtTail(data);
            return;
        }
        // position is in between kahin par insert karna chahte ho
        Node temp = head;

        // Move prevNode by (position -2) steps, to reach to the previous of the destination location
        for(int i=1; i<= position-2; i++) {
            temp = temp.next;
        }

        // ab mera temp previous node par aa chuka hai
        Node prevNode = temp;
        Node nextNode = prevNode.next;
        Node currNode = new Node(data);

        // linking time
        currNode.prev = prevNode;
        currNode.next = nextNode;

        prevNode.next = currNode;
        nextNode.prev = currNode;

        // Size increase
        size++;
    }

    // ====================
    // TRAVERSAL
    // ====================

    public void printList() {
        Node temp = head;

        while(temp!=null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printBackward(){
        Node temp = tail;
        while(temp != null){
            System.out.print("<-" + temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }
    
    // ====================
    // UTILITY FUNCTIONS
    // ====================

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getHead() {
        if(head == null) {
            return -1;
        }
        else {
            return head.data;
        }
    }

    public int getTail() {
        if(tail == null) {
            return -1;
        }
        else {
            return tail.data;
        }
    }

    public void clear() {
        if(head != null) {
            head = null;
        }

        // update size
        size=0;
    }

    // ====================
    // SEARCH
    // ====================    

    public boolean search(int target) {
        if(head == null){
            System.out.println("LL is Empty");
            return false;
        }

        Node temp = head;
        
        while(temp != null){
            if(temp.data == target){
                return true;
            }
            else{
                temp = temp.next;
            }
        }
        return false;
    }

    // ====================
    // UPDATE
    // ====================    


    // Update first occurrence of value
    public boolean updateValue(int oldValue, int newValue) {
       return true;
    }

    // ====================
    // DELETION
    // ====================     

    // deletion at head
    public void deleteHead(){

        // when no node is present in LL
       if(head == null ){
        System.out.println("Empty LL no deletion possible");
        return;
       }

       // when only one node is present
       if(head == tail){
        head = null;
        tail = null;
       }

       // Main logic
       Node temp = head;
       head = temp.next;

       temp.next = null;
       head.prev = null;
    
       // Update size
       size--;
    }

    // delete at tail
    public void deleteTail() {

        // when no node is present 
        if(tail == null){
            System.out.println("Empty DLL no deletion possible");
            return;
        }
        // when only one node is present
        if(head == tail){
            head = null;
            tail = null;

            // update size
            size=0;
            return;
        }

        // main logic
        tail = tail.prev;
        tail.next = null;

        // Update size
        size--;
    }

    // delete at any position
    public void deleteAtPosition(int position){

        // when position is invalid
        if(position < 1 || position > size+1){
            System.out.println("Invalid Position");
            return;
        }

        // when position is head
        if(position == 1){
            deleteHead();
            return;
        }

        // when position is tail
        if(position == size){
            deleteTail();
            return;
        }

        // when position is in between LL
        Node temp = head;
        for(int i=1; i<=position-1; i++){
            temp = temp.next;
        }

        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        // main logic
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        temp.prev = temp.next = null;

        // update size
        size--;
    }


    public static void main(String[] args){
        DoublyLinkedList mylist = new DoublyLinkedList();

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

        mylist.insertAtPosition(4,1000);
        mylist.printList();

        mylist.insertAtPosition(5,1001);
        mylist.printList();

        mylist.insertAtPosition(6,1002);
        mylist.printList();

        mylist.insertAtPosition(7,1003);
        mylist.printList();

        mylist.printBackward();

        System.out.println("Found or Not : " +mylist.search(110));

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteTail();
        mylist.printList();
    
        mylist.deleteTail();
        mylist.printList();
        
        mylist.deleteTail();
        mylist.printList(); 
        
        mylist.deleteAtPosition(1);
        mylist.printList();

        mylist.deleteAtPosition(5);
        mylist.printList();

        mylist.deleteAtPosition(3);
        mylist.printList();
    }
}
