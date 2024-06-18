public class Solution1214{

    public static void preorder(Node node){
        if(node != null){
            System.out.println(node.val);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.val);
        }
    }
    
    public static void main(String[] args){
        Node root = createTree();
        preorder(root);
        postorder(root);
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