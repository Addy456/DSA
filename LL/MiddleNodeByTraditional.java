public class MiddleNodeByTraditional {
     public class Node{
        int val;
        Node next;
        Node() {}
        Node(int x){val = x;}
    }

    public Node mid(Node head){
        Node temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }

        temp = head;
        for(int i = 1; i <= count/2; i++){
            temp = temp.next;
        }

        return temp;
    }

    public static void main(String[] args) {
        
    }
}
