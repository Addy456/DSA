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
}
