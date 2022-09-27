package linked_lists.questions;

import linked_lists.LinkedListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        // input
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        // print
        System.out.println("\nPrint Initial Linked List");
        printLinkedList(node1);

        // reverse
        LinkedListNode reversedNode = reverse(node1);

        // print
        System.out.println("\nPrint Reversed Linked List");
        printLinkedList(reversedNode);
    }

    public static LinkedListNode reverse(LinkedListNode node){
        LinkedListNode rootNode = node;
        LinkedListNode current = node;
        LinkedListNode next = current.getNext();

        while(next!=null){
            LinkedListNode NNext = next.getNext();
            next.setNext(current);
            current = next;
            next = NNext;
        }

        rootNode.setNext(null);
        rootNode = current;

        return rootNode;
    }

    public static void printLinkedList(LinkedListNode rootNode){
        LinkedListNode ptr = rootNode;
        while (ptr!=null){
            System.out.println(ptr.getValue());
            ptr = ptr.getNext();
        }
    }
}
