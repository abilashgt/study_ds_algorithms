/*
Print nodes at k distance from root

https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 */

package trees.search.questions;

import trees.Node;

public class KDistance {
    Node root;

    public static void main(String[] args) {

        KDistance tree = new KDistance();

        tree.root = new trees.Node(1);
        tree.root.left = new trees.Node(2);
        tree.root.right = new trees.Node(3);
        tree.root.left.left = new trees.Node(4);
        tree.root.left.right = new trees.Node(5);

        int k = 2;
        printLevel(tree.root, k);

    }

    public static void printLevel(Node root, int level){
        if(root==null) return;
        else if(level==1) System.out.println(root.value);
        else if(level>1) {
            printLevel(root.left, level-1); printLevel(root.right, level-1); }
    }
}
