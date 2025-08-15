package Singly_Linked_List;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Remove_Cycle_LL {
    static Node head;
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle= false;
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            slow = head;
            Node prev = null;
            while (slow!=fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }

    }
    public static void printList(Node node) {
        int count = 0; // to avoid infinite loop
        while (node != null && count < 20) {
            System.out.print(node.data + " -> ");
            node = node.next;
            count++;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;

        printList(head);
        removeCycle();
        printList(head);
       
    }
}
