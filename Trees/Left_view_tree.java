import java.util.LinkedList;
import java.util.Queue;

class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

public class Left_view_tree {

    public static void leftView(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i =0;i< size;i++){
                Node curr = queue.poll();

                if(i==0){
                    System.out.print(curr.data+" ");
                }
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }

            }
        }

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

        System.out.print("Left View: ");
        leftView(root);
    }
}
