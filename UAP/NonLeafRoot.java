package UAP;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// class Node {
//     Node left;
//     Node right;
//     int value;
//     Node(int value) {
//         this.value = value;
//         left = right = null;
//     }
//     boolean hasChild(Node root){
//         if(root.right != null || root.left != null){
//             return true;
//         }
//         return false;
//     }
// }

// class Binary_Tree {
//     Node root;

//     Binary_Tree() {
//         root = null;
//     }

//     Binary_Tree(int key) {
//         root = new Node(key);
//     }

//     void insertion(int value) {
//         //Isi sendiri
//         root = insertRecursive(root, value);
//     }

//     int getSum() {
//         //Isi sendiri
//     }
// }

// public class NonLeafRoot {

//     public static void main(String[] args) {
//         Binary_Tree binaryTree = new Binary_Tree();
//         Scanner in = new Scanner(System.in);
//         int testCases = in.nextInt();
//         for (int i = 0 ; i < testCases; i++) {
//             binaryTree.insertion(new Node(in.nextInt()));
//         }
//         System.out.println(binaryTree.getSum());
//     }
// }

public class NonLeafRoot {
    public static void main(String[] args) {
        Binary_Tree binarytree = new Binary_Tree();
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        int[] angka = new int[100];
        int data;
        for (int i = 0; i < testCases; i++) {
            data = in.nextInt();
            binarytree.insertion(data);
        }
        System.out.println(binarytree.getsum());

    }
}


class Binary_Tree {
    class Node {
        int key;
        Node left, right;
    
        public Node(int item) {
            key = item;
            left = right = null;
        }
    
        boolean hasChild(Node root){
            if(root.right != null || root.left != null){
                return true;
            }
            return false;
        }
    }
    Node root;
    int jumlah;

    Binary_Tree() {
        root = null;
    }

    Binary_Tree(int value) {
        root = new Node(value);
    }

    void insertion(int key) {
        root = insertRecursive(root, key);
    }

    Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);
        return root;
    }

    void inorder() {
        inorderRecursive(root);
    }
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.key);
            inorderRecursive(root.right);
        }
    }

    int getsum(){
        sumRecursive(root);
        return jumlah - root.key;
    }
    void sumRecursive(Node root){
        if (root != null) {
            sumRecursive(root.left);

            if(root.hasChild(root)){
                jumlah += root.key;
            }
            sumRecursive(root.right);
        }
    }
}