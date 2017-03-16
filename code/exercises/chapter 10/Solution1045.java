public class Solution1045{

    public static void iterativeTraversal(Node root){
        // go left
        // when can't, print, go right
        // when can't go right, go parent, go right

        // we either came from top, when no issue print
        // else we came up from left child, then go to right child
        // else we came from the right child then go up again

        Node node = root;
        boolean shouldPrint = true, fromLeft = false, fromRight = false;
        while(node != null){
            // normal flow
            if(shouldPrint){
                System.out.println(node.val);
            }
            // came from bottom, now lets check if from left or right
             else{
                shouldPrint = true;

                // if from left then try going right, if can't then go up again
                if(fromLeft){
                    fromLeft = false;
                        
                    if(node.right != null){
                        node = node.right;
                    } else {
                        if(node.parent == null){
                            break;
                        }
                        if(node == node.parent.left){
                            fromLeft = true;
                        } else{
                            fromRight = true;
                        }
                        node = node.parent;
                        shouldPrint = false;
                    }
                    continue;
                } else{
                    shouldPrint = false;
                    node = node.parent;
                    if(node == null || node.parent == null){
                        break;
                    }
                    if(node != null){
                        if(node == node.parent.left){
                            fromLeft = true;
                        } else{
                            fromRight = true;
                        }
                        node = node.parent;
                    }
                }
            }
            if(node.left != null){
                node = node.left;
            } else if(node.right != null){
                node = node.right;
            } else {
                node = node.parent;
                shouldPrint = false;
            }
        }
    }

    public static void main(String[] args){
        Node root = createTree();
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