import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees_Transversal {

    static class Node {
        Node left, right;
        int data;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length) return null;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void PreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void levelOrder(Node node) {
        if (node == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null); 
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) break;
                q.add(null);
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) q.add(currNode.left);
                if (currNode.right != null) q.add(currNode.right);
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree.idx = -1; 
        Node root = BinaryTree.buildTree(nodes);

        System.out.println("Root: " + root.data);
        
        System.out.print("Preorder Traversal: ");
        PreOrder(root);
        System.out.println();

        System.out.print("Inorder Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        postOrder(root);
        System.out.println();

        System.out.println("Level Order Traversal:");
        levelOrder(root);
    }
}
