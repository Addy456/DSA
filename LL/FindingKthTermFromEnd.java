public class FindingKthTermFromEnd {
    public class Node{
        int val;
        Node next;
        Node (){}
        Node (int x){val = x;}
    }

    public int findKfromEnd(Node head,int k){
        Node prev = head;
        Node curr = head;

        for (int i = 1; i<=k; i++){
            curr = curr.next;
        }

        while(curr != null){
            prev = prev.next;
            curr = curr.next;
        }

        return prev.val;
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
        FindingKthTermFromEnd obj = new FindingKthTermFromEnd();

        Node n1 = obj.new Node(10);
        Node n2 = obj.new Node(20);
        Node n3 = obj.new Node(30);
        Node n4 = obj.new Node(40);
        Node n5 = obj.new Node(50);
        Node n6 = obj.new Node(15);
        Node n7 = obj.new Node(25);
        Node n8 = obj.new Node(35);
        Node n9 = obj.new Node(45);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        System.out.println("original list 1 :");
        obj.printList(n1);        

        System.out.println("Value At kth Position From End : "+obj.findKfromEnd(n1, 3));
        
    }
    
}
