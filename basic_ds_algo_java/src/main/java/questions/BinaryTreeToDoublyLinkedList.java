package questions;

import linked_lists.DoubleLinkedListNode;


public class BinaryTreeToDoublyLinkedList {
    public static trees.Node tNode;

    public static DoubleLinkedListNode dNode;
    public static DoubleLinkedListNode preDNode;
    public static DoubleLinkedListNode currentDNode;

    public static void main(String[] args) {
        tNode = new trees.Node(0);
        trees.Node tNode1 = new trees.Node(1);
        trees.Node tNode2 = new trees.Node(2);
        tNode.left = tNode1; tNode.right = tNode2;

        trees.Node tNode3 = new trees.Node(3);
        trees.Node tNode4 = new trees.Node(4);

        inorderTraversalTree(tNode);

        traverseDNode(dNode);
    }

    static DoubleLinkedListNode inorderTraversalTree(trees.Node tNode){
        if(tNode==null) return currentDNode;
        inorderTraversalTree(tNode.left);

        if(dNode==null) {
            currentDNode = new DoubleLinkedListNode(tNode.value);
            dNode = currentDNode;
            preDNode = currentDNode;
        } else {
            preDNode = currentDNode;
            currentDNode = new DoubleLinkedListNode(tNode.value);
            preDNode.next = currentDNode;
            currentDNode.pre = preDNode;
        }

        inorderTraversalTree(tNode.right);
        return currentDNode;
    }

    static void traverseDNode(DoubleLinkedListNode currentDNode){
        if(currentDNode==null) return;
        System.out.println(currentDNode.val);
        traverseDNode(currentDNode.next);
    }

}
