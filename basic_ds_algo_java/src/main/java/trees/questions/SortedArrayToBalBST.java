package trees.questions;

/*
 Sorted Array to Balanced BST
 Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.
 Examples:

 Input:  Array {1, 2, 3}
 Output: A Balanced BST
    2
  /  \
 1    3

 Input: Array {1, 2, 3, 4}
 Output: A Balanced BST
      3
    /  \
   2    4
  /
 1

 REFERENCE:
 https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 */

import trees.Node;

public class SortedArrayToBalBST {

    Node sortedArrayToBST(int arr[], Integer start, Integer end) {
        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);

        // left subtree
        node.left = sortedArrayToBST(arr, start, mid - 1);

        // right subtree
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public static void preOrder(Node root){
        if(root==null) return;
        preOrder(root.left);
        System.out.println(root.getKey());
        preOrder(root.right);
    }

    public static void main(String[] args) {
        SortedArrayToBalBST tree = new SortedArrayToBalBST();
        //int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int arr[] = new int[]{1, 2, 3, 4};
        int n = arr.length;
        Node root = tree.sortedArrayToBST(arr, 0, n - 1);

        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }
}
