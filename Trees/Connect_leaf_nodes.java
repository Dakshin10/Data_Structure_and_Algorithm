class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class Connect_leaf_nodes {

    static Node prev = null,head = null;

    public static void connectLeaves(Node node){
        if(node == null){
            return;
        }

        //Using inOrder Transversal 
        connectLeaves(node.left);
        if(node.left== null && node.right==null){  // if yes then it is a  leaf node

            if(head == null){
                head = node;
            }
            else{
                prev.right = node;
                node.left = prev;
            }
            prev = node;
        }
        connectLeaves(node.right);
    }

    public static void print(){
        Node curr = head;
        System.out.println("The connected nodes");
        while (curr!=null) {
            System.out.print(curr.data+" ");
            curr = curr.right;
        }
        System.out.println();
    }


    public static void main(String[] args) {
//         1
//       /   \
//      2     3
//     / \     \
//    4   5     6
//       / \
//      7   8

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        
        connectLeaves(root);
        print();
    }

}
