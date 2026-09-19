public class MergeTwoSortedLL {
    public class Node{
        int val;
        Node next;
        Node(){}
        Node(int x){val = x;}
    }    

    public Node merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node head = dummy;
        Node tail = dummy;

        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            }
            else{
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }

        if(head1 != null){
            tail.next = head1;
        }

        if(head2 != null){
            tail.next = head2;
        }

        head = head.next;
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
        MergeTwoSortedLL obj = new MergeTwoSortedLL();

        Node n1 = obj.new Node(10);
        Node n2 = obj.new Node(20);
        Node n3 = obj.new Node(30);
        Node n4 = obj.new Node(40);
        Node n5 = obj.new Node(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node m1 = obj.new Node(15);
        Node m2 = obj.new Node(25);
        Node m3 = obj.new Node(35);
        Node m4 = obj.new Node(45);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        System.out.println("original list 1 :");
        obj.printList(n1);

        System.out.println("original list 2 :");
        obj.printList(m1);
        

        System.out.println("merge list :");
        obj.printList(obj.merge(n1,m1));
    }
}
