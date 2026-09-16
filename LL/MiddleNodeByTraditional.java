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

     public void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MiddleNodeByTraditional obj = new MiddleNodeByTraditional();

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

        System.out.println(obj.mid(n1).val);
    }
}
