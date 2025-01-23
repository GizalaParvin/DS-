import java.util.*;
import javax.swing.RootPaneContainer;

public class BST {
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
    
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // Insert in the left subtree
            root.left = insert(root.left, val);
        } else {
            // Insert in the right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        // Traverse left subtree
        inorder(root.left);
        // Print the root data
        System.out.print(root.data + " ");
        // Traverse right subtree
        inorder(root.right);
    }
    public static boolean search(Node root,int key) { //O(H)
        if (root == null) {
            return false;
        }
        if(root.data > key){
            //left subtree
            return search(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else {
            return  search(root.right, key);
        }
    }

    // Delete a Node
    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left,val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else { //root.data == val

            //case 1
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2 
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            delete(root.right,IS.data);

        }
        return root;
    }    
    
    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //PrintInRange
    public static void printInRange(Node root, int X, int Y) {
        if(root == null){
            return;
        }
        if(root.data >= X && root.data <=Y){
            printInRange(root.left, X, Y);
            System.out.println(root.data+" ");
            printInRange(root.right, X , Y);
        
        }
        else if(root.data >= Y){
            printInRange(root.left,X,Y);
        }
        else {
            printInRange(root.right, X, Y);
        }
    }

    //RootToLeaf
    public static void printPath(ArrayList<Integer> path){
        for(int i =0; i<path.size(); i++) {
            System.out.print(path.get(i)+ "->");
        }
        System.out.println();

    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null){
            return;
        }

        path.add(root.data);
        //leaf
        if(root.left == null && root.right == null){
            printPath(path);
        } else{ //non-leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        // Build the binary search tree
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        
        // Perform in-order traversal and print the tree
        System.out.println("Inorder traversal of the BST:");
        inorder(root);
        System.out.println();

        if(search(root, 8)){
            System.out.println("found");
        }else {
            System.out.println("Not found");
        }

        System.out.println();
        inorder(root);
        System.out.println();

        delete(root,5);
        inorder(root);
        System.out.println();

        for(int i = 0; i<values.length; i++){
            root = insert(root, values[i]);
        }
       
        inorder(root);
        System.out.println();
        printInRange(root, 6,10);

        //root@leaf
        printRoot2Leaf(root, new ArrayList<>());

    }
}
 