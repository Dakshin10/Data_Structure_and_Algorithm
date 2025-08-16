
public class Height_of_Tree_Array {

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


    public static int Height(Node node){
        if(node == null){
            return -1;
        }
        return Math.max(Height(node.left),Height(node.right)) +1;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree.idx = -1; 
        Node root = BinaryTree.buildTree(nodes);

        System.out.println("Height: "+Height(root));

    }
}
