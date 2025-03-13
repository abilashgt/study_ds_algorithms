package graphs.search;

/*
Depth First Search: Algo Expert

REFERENCE:
https://www.algoexpert.io/questions/depth-first-search
 */

import java.util.ArrayList;
import java.util.List;

class DepthFirstSearchByNode2 {
    public static void main(String[] args) {
        Node node0 = new Node("0");
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");

        node0.children.add(node1);
        node0.children.add(node2);
        node1.children.add(node2);
        node2.children.add(node0);
        node2.children.add(node3);
        node3.children.add(node3);

        System.out.println("DFS:");

        List<String> output = new ArrayList<>();
        node2.depthFirstSearch(output);

        System.out.println(output);
    }


    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);

            for(Node child: children){
                if(!array.contains(child.name)) {
                    child.depthFirstSearch(array);
                }
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}