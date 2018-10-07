package tree.bfs;

import tree.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*

if Input tree:
  1
 2 3
4 5 6


Output:
1 2 3 4 5 6

 */

public class BreadFirstInsertAndSearch {

    Node root;

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        BreadFirstInsertAndSearch bTree = new BreadFirstInsertAndSearch();

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;

        try {
            while ((line = in.readLine()) != null) {
                Integer inputNode = Integer.parseInt(line);
                System.out.println(inputNode);
                bTree.insert(inputNode);
            }
        }
        catch (NumberFormatException e){

        }

        /*bTree.root = new Node(1);
        bTree.root.left = new Node(2);
        bTree.root.right = new Node(3);

        bTree.root.left.left = new Node(4);
        bTree.root.left.right = new Node(5);
        bTree.root.right.left = new Node(6);
        bTree.root.right.right = new Node(7);*/

        System.out.println("Height = "+bTree.findHeight());
        System.out.println("Bread First Search:");
        bTree.bfSearch();
    }

    void insert(int key){
        root = insert(this.root, key);
    }

    Node insert(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(root.left == null){
            root.setLeft(insert(root.getLeft(), key));
        }
        else if(root.right == null){
            root.setRight(insert(root.getRight(), key));
        }
        else if(root.left.left==null || root.left.right==null) {
            root.setLeft(insert(root.getLeft(), key));
        }
        else if(root.right.left==null || root.right.right==null){
            root.setRight(insert(root.getRight(), key));
        }
        else{
            root.setLeft(insert(root.getLeft(), key));
        }

        return root;
    }

    void bfSearch(){
        bfSearch(this.root);
    }

    void bfSearch(Node root){
        if(root!=null) {
            for(int i=1; i<=3; i++){
                printGivenLevel(root, i);
            }
        }
    }

    void printGivenLevel(Node root, int level){
        if(root == null) return;
        else if(level == 1) System.out.println(root.getKey());
        else if(level>1){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    Boolean isGivenLevelFull(Node root, int level){
        if(root == null) return false;
        else if(level == 2) {
            if(root.getLeft()==null) return false;
            if(root.getRight()==null) return false;
        }
        else if(level>2){
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }

        return true;
    }

    int findHeight(){
        return findHeight(this.root);
    }

    int findHeight(Node root){
        if(root == null) return 0;
        else {
            int lh = findHeight(root.left);
            int rh = findHeight(root.right);

            if(lh>rh){
                return lh + 1;
            }
            else{
                return rh + 1;
            }
        }
    }
}