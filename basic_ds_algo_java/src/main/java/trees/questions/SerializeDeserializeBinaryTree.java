package trees.questions;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ref: https://leetcode.com/explore/interview/card/google/65/design-4/3092/
 */

// public class Codec
public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = preorderS(root, "");
        System.out.println("final-"+result);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arrStr[] = data.split(",");
        Queue<String> queue = new LinkedList<String>();

        for(int i=0; i<arrStr.length; i++){
            queue.add(arrStr[i]);
        }

        // deserialize
        TreeNode root = preorderD(queue);

        return root;
    }

    // deserialise
    static TreeNode preorderD(Queue<String> queue){
        String item = queue.remove();

        if(!item.equals("null")){
            TreeNode root = new TreeNode(Integer.parseInt(item));
            root.left = preorderD(queue);
            root.right = preorderD(queue);
            return root;
        }

        return null;
    }

    // serialization
    static String preorderS(TreeNode root, String result){

        if(result!=""){
            result+=",";
        }

        if(root!=null){
            result += root.val;
            result = preorderS(root.left, result);
            result = preorderS(root.right, result);
        }
        else{
            result += "null";
        }

        return result;
    }
}
