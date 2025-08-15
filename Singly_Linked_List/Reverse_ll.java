package Singly_Linked_List;

class Node{
    Node next; 
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class Reverse_ll {   
    static Node head;
    public static Node reverse(){
        while(head==null || head.next ==null)return head;
        Node prev = null,curr = head, next = null;

        while(curr!=null){
            next = curr.next;//Store next node
            curr.next = prev;//Reverse the link
            prev = curr;     //Move prev node 
            curr = next;     //Move to current node
        }
        return prev;//New head of the Reversed Linked List
    }

    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.data+" -> ");
            head = head.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverse();

        System.out.println("Reversed Linked List:");
        printList(head);
    }
}
