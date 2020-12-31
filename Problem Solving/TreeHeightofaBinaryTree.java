import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
        int height = 0;
        int val = 0;
        if(root==null) return height;
        
        if(root.left!=null) 
            val  = Math.max(height,height(root.left, 1));
        
        if(root.right!=null)
            height  = Math.max(val,height(root.right, 1));  
            
        return height;
    }
    
    public static int height(Node root, int height) {
        int val = 0;
        if(root==null) return height;
        
        if(root.left!=null) 
            val  = Math.max(height,height(root.left, height+1));
        
        if(root.right!=null)
            height  = Math.max(val,height(root.right, height+1));  
        else 
            height = Math.max(val, height);
        
        return height;  
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}