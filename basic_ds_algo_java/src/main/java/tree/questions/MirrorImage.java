package tree.questions;

/*
Symmetric Tree (Mirror Image of itself)
Given a binary tree, check whether it is a mirror of itself.

For example, this binary tree is symmetric:

     1
   /   \
  2     2
 / \   / \
3   4 4   3


But the following is not:

    1
   / \
  2   2
   \   \
   3    3

REFERENCE
https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
 */

import tree.Node;

public class MirrorImage {
    Node root;

    public static void main(String[] args) {
        MirrorImage tree = new MirrorImage();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = tree.isSymmetric();
        if (output == true)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public boolean isSymmetric(){
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(Node nodeLeft, Node nodeRight){
        if(nodeLeft == null && nodeRight == null) return true;

        if(nodeLeft!=null && nodeRight!=null && nodeLeft.key==nodeRight.key) {
            return isMirror(nodeLeft.left, nodeRight.right) && isMirror(nodeLeft.right, nodeRight.left);
        }

        return false;
    }
}
