class ReverseListByIteration {
    public class Node{
        int val;
        Node next;
        Node() {}
        Node(int x){val = x;}
    }

    public Node reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;

        while (curr != null){
            Node forw = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }    
    public static void main(String[] args){}
}
