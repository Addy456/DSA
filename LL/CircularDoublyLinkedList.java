public class CircularDoublyLinkedList {
    
    // creating node
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
        // when LL is empty
        if(head == null){
            head = tail = newNode;
            
            tail.next = head;
            head.prev = tail;
        }
        // when LL have atleat one node
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
        // when LL is empty
        if(tail == null){
            head = tail = newNode;

            tail.next = head;
            head.prev = tail;
        }
        // when LL have atleast one Node
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
        
        // when position is invalid
        if(position < 1 || position > size + 1){
            System.out.println("Positions are invalid");
            return;
        }

        // when posiyion is head
        if(position == 1){
            insertAtHead(data);
            size++;
            return;
        }

        // when position is tail
        if(position == size+1){
            insertAtTail(data);
            size++;
            return;
        }

        // when position is middle in the Linked list
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

    //===================
    //Utility function
    //===================

    // print forward list head->tail
    public void printList(){
        if(head == null ){
            System.out.println("Circular linked list is empty");
            return;
        }

        Node temp = head;

        do{
            System.out.print(temp.data +"->");
            temp = temp.next;
        }while(temp != head);

        System.out.println("Back to head");
    }

    // print list backward tail->head
    public void printBackwardList(){
        if(tail == null){
            System.out.print("Circular linked list is empty");
            return;
        }

        Node temp = tail;

        do{
            System.out.print(temp.data +"->");
            temp = temp.prev;
        }while(temp != tail);

        System.out.println("Back to tail");
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getHead(){
        if(head == null){
            throw new IllegalStateException(
                "Circular Linked List is Empty"
                
            );
        }
        return head.data;
    }

    public int getTail(){
        if(tail == null){
            throw new IllegalStateException(
                "Circular Linked List is Empty"
            );
        }
        return tail.data;
    }
    
    //===================
    //searching
    //===================
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
        }while(temp != head);
        return false;
    }

    //===================
    //Deletion
    //===================

    // delete at head
    public void deleteAtHead(){
        // when LL is empty
        if(head == null){
            System.out.println("CDLL is Empty deletion not possible");
            return;
        }
        // when LL have only one node
        if(head == tail){
            head = tail = null;
        }

        else{
        head = head.next;

        tail.next = head;
        head.prev = tail;
        }

        // update size
        size--;
    }

    // delete at tail
    public void deleteAtTail(){
        // when LL is empty
        if(tail == null){
            System.out.println("CDLL is empty no deletion possible");
            return;
        }

        // when LL have only one node
        if(head == tail){
            head = tail = null;
        }
        else{
            tail = tail.prev;
            
            tail.next = head;
            head.prev = tail;
        }

        // update size
        size--;
    }

    public void deleteAtPosition(int position){
        if(position < 1 || position > size + 1){
            System.out.println("Invalid Position");
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

        for(int i=1; i < position-1; i++){
            prevNode = prevNode.next;
        }

        Node currNode = prevNode.next;
        Node nextNode = currNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        currNode.next = currNode.prev = null;

        // update size
        size--;
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList mylist = new CircularDoublyLinkedList();

        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(30);
        mylist.printList();

        mylist.insertAtHead(40);
        mylist.printList();

        mylist.insertAtHead(50);
        mylist.printList();

        mylist.insertAtTail(100);
        mylist.printList();

        mylist.insertAtTail(110);
        mylist.printList();

        mylist.insertAtTail(120);
        mylist.printList();

        mylist.insertAtTail(130);
        mylist.printList();

        mylist.insertAtTail(130);
        mylist.printList();

        mylist.insertAtPosition(1,1000);
        mylist.printList();

        mylist.insertAtPosition(10,1001);
        mylist.printList();

        mylist.insertAtPosition(5,0);
        mylist.printList();

        mylist.getHead();
        mylist.getTail();
        mylist.getSize();

        System.out.println("Found or not :"+mylist.search(100));

        mylist.deleteAtHead();
        mylist.printList();

        mylist.deleteAtTail();
        mylist.printList();

        mylist.deleteAtPosition(4);
        mylist.printList();

        mylist.printBackwardList();

        System.out.println("list is emplt or not :"+mylist.isEmpty());
    }
}
