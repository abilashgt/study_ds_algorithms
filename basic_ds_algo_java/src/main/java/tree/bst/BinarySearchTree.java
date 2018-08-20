package tree.bst;

import tree.Node;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int key){
        root = insert(this.root, key);
    }

    Node insert(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.getKey()){
            root.setLeft(insert(root.getLeft(), key));
        }
        else{
            root.setRight(insert(root.getRight(), key));
        }

        return root;
    }

    void inorder(){
        inorder(this.root);
    }

    void inorder(Node root){
        if(root!=null) {
            inorder(root.getLeft());
            System.out.println(root.getKey());
            inorder(root.getRight());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.insert(10);
        bsTree.insert(11);
        bsTree.insert(9);

        bsTree.inorder();
    }
}
