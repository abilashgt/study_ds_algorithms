/*
Difference between sums of odd level and even level nodes of a Binary Tree

https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
 */

package trees.search.questions;

import trees.Node;

public class SumsOfOddAndEven {
    Node root;

    int sumOdd = 0;
    int sumEven = 0;

    public static void main(String[] args) throws Exception {

        SumsOfOddAndEven tree = new SumsOfOddAndEven();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.totalSum();
    }

    public void totalSum() throws Exception{
        int n = findHeight(root);

        for(int i=1; i<=n; i++){
            if(i%2==0) sumEven += sumLevel(root, i);
            else sumOdd += sumLevel(root, i);
        }

        System.out.println("Sum of Odd = "+sumOdd);
        System.out.println("Sum of Even = "+sumEven);
    }

    public static int findHeight(Node root){
        if(root==null) return 0;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        if(lh>rh) return lh+1;
        else return rh+1;
    }

    public static int sumLevel(Node root, int level) throws Exception {
        if(root==null) return 0;
        else if(level==1) return root.value;
        else if(level>1) {
            int ls = sumLevel(root.left, level-1);
            int rs = sumLevel(root.right, level-1);
            return ls+rs;
        }
        throw new Exception("algorithm error");
    }
}
