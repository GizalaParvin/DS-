import com.sun.source.tree.Tree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesYT {
    static class Node {
        int data;
        Node left;
        Node right;


        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {
        static int idx =-1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx]==-1){
               
              return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder

    public static void preorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder

    public static void inorder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    //Postorder
    public static void postorder(Node root){
        if(root==null){
            System.out.println(-1 +" ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data + " ");
    }

    // Level order

    public static void levelorder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                // queue empty
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
     
    //Count Of Nodes
    public static int countOfNodes(Node root){
        if(root ==null){
            return 0 ;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    //Sum of Nodes
    public static int sumOfNodes(Node root){
        if(root ==null){
            return 0 ;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // Height of tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
        
    //Diameter of tree
    //Approach 1 O^2
    public static int diameter(Node root){
        if(root == null){
            return 0 ;
        }

        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max(dia3, Math.max(dia1, dia2));
    }

    //Approach 2 O(N)
    public static TreeInfo diameter2(Node root) {
        if(root == null){
            new TreeInfo(0,0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht , right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;

        int mydia = Math.max(Math.max(dia1,dia2),dia3);
        TreeInfo myInfo = new TreeInfo(myHeight , mydia);
        return myInfo;

    }

    public static void main(String[] args) {
        int  nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root =tree.buildTree(nodes);
        System.out.println(root.data);
        
        System.out.println("\npreorder");
        preorder(root);

        System.out.println("\ninorder");
        inorder(root);

        // System.out.println("Postorder");
        // postorder(root);

        System.out.println("\nLevelOrder");
        levelorder(root);


        System.out.println("Count Of Nodes");
        System.out.println(countOfNodes(root));

        
        System.out.println("Sum Of Nodes");
        System.out.println(sumOfNodes(root));

        System.out.println("Height of tree");
        System.out.println(height(root));




    }
}
