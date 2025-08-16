class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class SubTree_of_AnotherTree {
    public static boolean isSubTree(Node root, Node subRode){
        if(root == null){
            return false;
        }
        if(isSame(root, subRode)){
            return true;
        }

        return isSubTree(root.left, subRode) || isSubTree(root.right, subRode);

    }

    public static boolean isSame(Node root, Node subRoot){
        if(root == null && subRoot== null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.data != subRoot.data){
            return false;
        }

        return isSame(root.left, subRoot.left) && isSame(root.right , subRoot.right);
    }

     public static void main(String[] args) {
        
        // root =        3
        //              / \
        //             4   5
        //            / \
        //           1   2
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        // Subtree
        // subRoot =    4
        //             / \
        //            1   2
        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        System.out.println(isSubTree(root, subRoot)); 
    }
}
