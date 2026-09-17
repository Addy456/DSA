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
       
    }

}
