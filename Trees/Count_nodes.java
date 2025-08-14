class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
public class Count_nodes {
    static Node root;

    public static int CountNode(Node node){
        if(node == null){
            return 0;
        }
        int leftCount = CountNode(node.left);
        int rightCount = CountNode(node.right);

        return leftCount+rightCount+1;
    }

    public static void main(String[] args) {
//         1
//       /   \
//      2     3
//     / \     \
//    4   5     6
//         \
//          7

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.right = new Node(7);

        System.out.print("Number of Nodes in the tree: "+CountNode(root));

    }
}
