package BinarySearchTree;

import java.io.*;
import java.util.*;

public class TreeNode {

    Object data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
        this.data = data;
    }
}

class BinaryTree {

    private static final String String = null;
    TreeNode root;

    public boolean isEmpty() {
        return (root == null);
    }

    //method insert data
    public void insert(TreeNode input) {
        if (isEmpty()) {
            root = input;
        } else {
            // cari parent yg sesuai dan (kiri/kanan)
            TreeNode current = root;
            TreeNode parent = null;
            boolean diKiri = true;
            while (current != null) {
                parent = current;
                // kalau data yang akan diinputkan lebih besar,
                // bergerak ke kanan
                if (current.data !=null) {
                    current = current.right;
                    diKiri = false;
                    // else gerak ke kiri
                // } else if (current.data = null) {
                //     current = current.left;
                //     diKiri = true;
                } else {
                    System.out.println("data " + input.data + " sudah ada");
                    break;
                }
            }
            // hubungkan ke parent
            if (diKiri) {
                parent.left = input;
            } else {
                parent.right = input;
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void preOrder(TreeNode akar) {
        if (akar != null) {
            System.out.print(akar.data + " ");
            preOrder(akar.left);
            preOrder(akar.right);
        }
    }

    public void inOrder(TreeNode akar) {
        if (akar != null) {
            inOrder(akar.left);
            System.out.print(akar.data + " ");
            inOrder(akar.right);
        }
    }

    public void postOrder(TreeNode akar) {
        if (akar != null) {
            postOrder(akar.left);
            postOrder(akar.right);
            System.out.print(akar.data + " ");
        }
    }
    //method mencari data

    public TreeNode search(Object key) {
        TreeNode node = null;
        TreeNode current = root;
        // lakukan pencarian selama current bukan null
        while (current != null) {
            if (current.data == key) {
                return node;
            } else {
                if (current.data < key) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
        }
        return node;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        TreeNode node;

        node = new TreeNode();
        tree.insert(node);

        node = new TreeNode();
        tree.insert(node);

        node = new TreeNode();
        tree.insert(node);

        System.out.print("Traversal dengan preorder :");
        tree.preOrder();
        System.out.print("\nTraversal dengan inorder :");
        tree.inOrder();
        System.out.print("\nTraversal dengan postorder :");
        tree.postOrder();
        System.out.println();

    }
}