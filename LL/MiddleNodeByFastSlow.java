public class MiddleNodeByFastSlow {
     public class Node{
        int val;
        Node next;
        Node() {}
        Node(int x){val = x;}
    }

    public Node mid(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {}
}
