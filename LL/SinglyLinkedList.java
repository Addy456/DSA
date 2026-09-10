public class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // ====================
    // INSERTION
    // ====================

    // Insertion at head
    public void insertAtHead(int data) {
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
    public void insertAtTail(int data) {
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
    public void insertAtPosition(int position, int data) {
        if(position < 1 || position > size+1) {
            // insertion not position
            System.out.println("Insertion is not possible at this position");
            return;
        }
        if(position == 1) {
            insertAtHead(data);
            return;
        }
        if(position == size+1) {
            insertAtTail(data);
            return;
        }
        // Middle me kahin par insert karna chahte ho
        Node prevNode = head;

        // Move prevNode by (position -2) steps, to reach to the previous of the destination location
        for(int i=1; i<= position-2; i++) {
            prevNode = prevNode.next;
        }

        Node newNode = new Node(data);

        // Update links
        newNode.next= prevNode.next;
        prevNode.next = newNode;

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
        Node temp = head;
        while (temp != null){
            if(temp.data == target) {
                return true;
            }
            else {
                temp = temp.next;
            }
        }
        return false;
    }

    public int findPosition(int target) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if(temp.data == target) {
                return position;
            }
            else {
                temp = temp.next;
                position++;
            }
        }
        return -1;
    }

    // ====================
    // UPDATE
    // ====================    

    // update using position
    public void updateATPositin(int position, int newData) {
        if(position < 1 || position > size+1) {
            System.out.println("Invalid position given in input");
            return;
        }

        Node temp = head;

        for(int i=1; i<= position-1; i++) {
            temp = temp.next;
        }

        temp.data = newData;
        
    }

    // Update first occurrence of value
    public boolean updateValue(int oldValue, int newValue) {
        Node temp = head;
        while(temp != null){
            if(temp.data == oldValue) {
                temp.data = newValue;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // ====================
    // DELETION
    // ====================     

    // deletion at head
    public void deleteHead(){
        if(head == null){
            System.out.println("LL is empty, cannot delete anything");
            return;
        }
        //main logic
        head = head.next;
        size--;

        if(head == null){
            tail = null;
        }
    }

    // delete at tail
    public void deleteTail() {
        if(tail == null){
            System.out.println("LL is empty, cannot delete anything");
            return;
        }

        // check for single node
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return;        
        }

        // main logic
        Node temp = head;
        for(int i=1;i<=size-2;i++) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;

        // updating size
        size--;
    }

    // delete at any position
    public void deleteAtPosition(int position){
        if(position < 1 || position > size+1){
            System.out.println("Invalid position, can't delete node");
            return;
        }

        if(position == 1){
            deleteHead();
            return;
        }

        if(position == size){
            deleteTail();
            return;
        }

        // varialbe setup -> prev,curr,forward
        Node prev = head;

        // prev ko position -2 steps move karunga to main nodeToDelete ke piche wali node par pahuch jaunga 
        for(int i=1; i<=position-2; i++){
            prev = prev.next;
        }
        Node curr = prev.next;
        Node forward = curr.next;

        // main logic
        prev.next = forward;
        curr.next = null;

        // update size
        size--;
    }

    public boolean deleteValue(int target){
        if(head == null){
            System.out.println("LL is empty, no element present in LL for deletion");
            return false;
        }

        if(head.data  == target ) {
            deleteHead();
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        while(curr != null){
            if(curr.data == target){
                Node forward = curr.next;

                // main logic
                prev.next = forward;
                curr.next = null;

                if(tail == curr){
                    tail = prev;
                }
                size--;
                return true;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return false;
    }

    public static void main(String [] args) {
        SinglyLinkedList mylist = new SinglyLinkedList();

        if(mylist.isEmpty()) {
            System.out.println("List is Empty");
        }

        System.out.println("Size of LL : "+mylist.getSize());

        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(30);
        mylist.printList();

        mylist.insertAtTail(100);
        mylist.printList();

        mylist.insertAtTail(110);
        mylist.printList();

        mylist.insertAtTail(120);
        mylist.printList();

        mylist.insertAtPosition(1,35);
        mylist.printList();

        mylist.insertAtPosition(8,200);
        mylist.printList();

        mylist.insertAtPosition(4,0);
        mylist.printList();

        mylist.insertAtPosition(7,125);
        mylist.printList();

        System.out.println(mylist.getHead());
        System.out.println(mylist.getTail());
        System.out.println("Found or Not : "+mylist.search(200));
        System.out.println("Found or Not : "+mylist.search(250));
        System.out.println("Position of you target : "+mylist.findPosition(45));
        System.out.println("Position of you target : "+mylist.findPosition(100));
        mylist.updateATPositin(5,1000 );
        mylist.printList();
        System.out.println("Updated or not: " +mylist.updateValue(0,1001));
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteTail();
        mylist.printList();

        mylist.deleteAtPosition(5);
        mylist.printList();

        mylist.deleteAtPosition(1);
        mylist.printList();

        mylist.deleteValue(125);
        mylist.printList();
        
    }
}    

