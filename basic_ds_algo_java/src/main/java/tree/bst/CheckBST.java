package tree.bst;

/*
A program to check if a binary tree is BST or not
A binary search tree (BST) is a node based binary tree data structure which has the following properties.
• The left subtree of a node contains only nodes with keys less than the node’s key.
• The right subtree of a node contains only nodes with keys greater than the node’s key.
• Both the left and right subtrees must also be binary search trees.
 */

import tree.Node;

public class CheckBST {
    private static Node bTree;

    public static void main(String[] args) {
        bTree = new Node(1);
        bTree.left = new Node(2);
        bTree.right = new Node(3);

        bTree.left.left = new Node(4);
        bTree.left.right = new Node(5);
        bTree.right.left = new Node(6);
        bTree.right.right = new Node(7);

        System.out.println("Is BST:" + isBST(bTree, Integer.MIN_VALUE, Integer.MAX_VALUE));

        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.insert(10);
        bsTree.insert(11);
        bsTree.insert(9);
        System.out.println("Is BST:" + isBST(bsTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /**
     *
     * @param bTree
     */
    public static boolean isBST(Node bTree, int min, int max){
       if(bTree==null){
           return true;
       }
       else if(bTree.key<min||bTree.key>max){
           System.out.println(bTree.key+" "+min+" "+max);
           return false;
       }

       return isBST(bTree.left, min, bTree.key) && isBST(bTree.right, bTree.key, max);
    }
}
