// Brute force approach present node ki copy karna fir use reverse karke previous vali se compaire karna 
// optimized solution
// first you have to break the LL into two by using slow and fast pointers from between

public class CheckPalindrome {

    public class Node{
        int val;
        Node next;
        Node() {}
        Node(int x){val = x;}
    }

    // method for finding middle of a LL
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

    // method for reversing a LL
    public Node isReverse(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node forw = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    // method of check a LL is palindrome or not
    public boolean ispalindrome(Node head){
        
        if(head == null || head.next == null){
            return true;
        }

        // Mid point LL break;
        Node list2 = mid(head);
        
        // List1, List2 seprated
        Node temp = head;

        while(temp.next != list2){
            temp = temp.next;
        }
        temp.next = null;

        // list2 -> reverse
        Node head2 = isReverse(list2);

        // List1 and List2 comparison
        Node temp1 = head;
        Node temp2 = head2; 
        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            else{   
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return true;
    }
    
    public void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        CheckPalindrome obj = new CheckPalindrome();

        Node n1 = obj.new Node(1);
        Node n2 = obj.new Node(2);
        Node n3 = obj.new Node(3);
        Node n4 = obj.new Node(3);
        Node n5 = obj.new Node(2);
        Node n6 = obj.new Node(1);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        System.out.println("Original List:");
        obj.print(n1);

        System.out.println("Palindrome: " + obj.ispalindrome(n1));
    }

}
