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
        if(position < 1 || position > size+1){
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

    public void clear(){
        if(head != null) {
            head = null;
        }

        // update size
        size=0;
    }

    public static void main(String [] args) {
        SinglyLinkedList mylist = new SinglyLinkedList();

        if(mylist.isEmpty()){
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


    }
}

