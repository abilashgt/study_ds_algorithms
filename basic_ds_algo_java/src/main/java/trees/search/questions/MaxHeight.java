package trees.search.questions;

import trees.Node;

/**
 * Write a Program to Find the Maximum Depth or Height of a Tree
 *
 */

public class MaxHeight {
    Node root;

    int maxDepth(Node node){
        if(node == null) return 0;

        /* compute the depth of each subtree */
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);

        if(lDepth>=rDepth) return (lDepth + 1);
        else return (rDepth+1);
    }

    public static void main(String[] args) {
        MaxHeight tree = new MaxHeight();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                tree.maxDepth(tree.root));
    }
}
