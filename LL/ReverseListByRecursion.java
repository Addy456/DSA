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

    public void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ReverseListByRecursion obj = new ReverseListByRecursion();

        Node n1 = obj.new Node(10);
        Node n2 = obj.new Node(20);
        Node n3 = obj.new Node(30);
        Node n4 = obj.new Node(40);
        Node n5 = obj.new Node(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println("original list");
        obj.printList(n1);

        

        System.out.println("reversed list");
        obj.printList(obj.reverseLinkedList(n1));
    }
}
