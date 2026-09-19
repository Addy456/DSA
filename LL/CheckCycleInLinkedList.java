public class CheckCycleInLinkedList {
    public class Node{
        int val;
        Node next;
        Node() {}
        Node(int x){val = x;}
    }

    public boolean checkCycle(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        CheckCycleInLinkedList obj = new CheckCycleInLinkedList();

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
        n8.next = n7;

        System.out.println("Cycle present : "+obj.checkCycle(n1));
    }
}
