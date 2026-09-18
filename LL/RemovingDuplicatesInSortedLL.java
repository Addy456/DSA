public class RemovingDuplicatesInSortedLL {
    public class Node{
        int val;
        Node next;
        Node(){}
        Node(int x){val = x;}
    }

    public Node isRemoveDuplicates(Node head){
        Node prev = head;
        Node curr = head.next;
        while(curr != null){
            if(prev.val != curr.val){
                prev = prev.next;
                curr = curr.next;
            }
            else{
                prev.next = curr.next;
                curr = prev.next;
            }
        }
        return head;
    }

    public void printList(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        RemovingDuplicatesInSortedLL obj = new RemovingDuplicatesInSortedLL();

        Node n1 = obj.new Node(1);
        Node n2 = obj.new Node(2);
        Node n3 = obj.new Node(2);
        Node n4 = obj.new Node(3);
        Node n5 = obj.new Node(4);
        Node n6 = obj.new Node(5);
        Node n7 = obj.new Node(5);
        Node n8 = obj.new Node(6);

        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        System.out.println("Original list:");
        obj.printList(n1);

        Node  temp = obj.isRemoveDuplicates(n1);

        System.out.println("New list:");
        obj.printList(temp);
        
    }
}
