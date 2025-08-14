//Diameter of a tree : Number of nodes in the longest path between 2 leaves
class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

public class Diameter_tree {
    public static int Height(Node node) {
    if (node == null) {
        return 0; // null has height 0
    }
    return Math.max(Height(node.left), Height(node.right)) + 1;
}

public static int Diameter_approach_1(Node node) {
    if (node == null) {
        return 0;
    }
    int leftDia = Diameter_approach_1(node.left);
    int leftHeight = Height(node.left);

    int rightDia = Diameter_approach_1(node.right);
    int rightHeight = Height(node.right);

    return Math.max(leftHeight + rightHeight + 1, Math.max(leftDia, rightDia));
}

    static Node root;
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

        System.out.print("Diameter of the tree: "+Diameter_approach_1(root));

    }
}
