import java.util.*;
/**
 * Inorder traversal basically
 */
public class Solution1213{

    public static void recursiveTraversal(Node node){
        if(node != null){
            recursiveTraversal(node.left);
            System.out.println(node.val);
            recursiveTraversal(node.right);
        }
    }
    
    public static void iterativeTraversalStack(Node node){

        if(node == null)
            return;

        Deque<Node> stack = new ArrayDeque<>();

        do{
            while(node != null){
                stack.offerLast(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pollLast();
                System.out.println(node.val);
                node = node.right;
                if(node != null){
                    while(node != null){
                        stack.offerLast(node);
                        node = node.left;
                    }
                }
            }

        } while(!stack.isEmpty());

    }

    public static void iterativeTraversal(Node node){
        
        if(node == null)
            return;

        // go as much left as you can
        // if no more left, print and try to go right
        //  if can then repeat above
        // else go up one level, print and check if came
        // from left then then try right step
        // else go up again

        boolean fromLeft = false, fromRight = false;

        while(node != null){

            if(!fromLeft && !fromRight){
                node = leftMost(node);
            }
            fromLeft = false;
            if(!fromRight){
                System.out.println(node.val);
            }
            
            if(!fromRight && node.right != null){
                node = node.right;
                fromRight = false;
            } else {
                fromRight = false;
                if(node.parent != null){
                    if(node == node.parent.left){
                        fromLeft = true;
                    } else {
                        fromRight = true;
                    }
                }
                node = node.parent;
            }
        }
    }

    private static Node leftMost(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args){
        Node root = createTree();
        // recursiveTraversal(root);
        // iterativeTraversalStack(root);
        iterativeTraversal(root);
    }

    public static Node createTree(){
        Node root = new Node(5);
        addNode(root, true, 4);
        addNode(root, false, 3);
        addNode(root.left, true, 1);
        addNode(root.left.left, true, 2);
        addNode(root.left.left.left, false, 7);

        return root;
    }

    public static void addNode(Node node, boolean isLeft, int val){
        if(isLeft){
            node.left = new Node(val, node);
        } else {
            node.right = new Node(val, node);
        }
    }

}

class Node{
    int val;
    Node parent, left, right;

    Node(int val){
        this(val, null, null, null);
    }

    Node (int val, Node parent){
        this(val, parent, null, null);
    }

    Node(int val, Node parent, Node left, Node right){
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}