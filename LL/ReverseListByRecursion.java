class ReverseListByRecursion {
    public class Node{
        int val;
        Node next;
        Node() {}
        Node(int x){val = x;}
    }

    public Node solve(Node prev, Node curr){
        // base case
        if(curr == null){
            return prev;
        }

        Node forw = curr.next;
        curr.next = prev;

        // move prev and curr 1 step ahead
        prev = curr;
        curr = forw;

        // recursive call
        return solve(prev,curr);
    }

    public Node reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;
        Node ans = solve(prev,curr);
        
        return ans;
    }    
    public static void main(String[] args){}
}
