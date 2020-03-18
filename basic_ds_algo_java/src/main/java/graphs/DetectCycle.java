package graphs;

/*
Depth First Search:

   0  >>>>>>> 1
  ^ V       /
  ^ V     /
  ^ V   /     >>>>
  ^ V /_      ^  V
   2  >>>>>>> 3<<<

REFERENCE:
https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DetectCycle {

    private Stack<Node> stack = new Stack<Node>();

    public void startDFS(Node g){
        List<Node> visited = new LinkedList<Node>();
        SearchDFS(g, visited);
    }

    public void SearchDFS(Node g, List<Node> visited){
        visited.add(g);
        stack.push(g);

        System.out.println("node="+g.val);

        for(Node n: g.neighbors){
            // System.out.println("neighbor="+n.val);
            if(!visited.contains(n)){
                SearchDFS(n, visited);
            }
            else if(!stack.empty()) {
                System.out.println("cycle exists="+n.val);

                while(stack.peek()!=n) {
                    System.out.print("-" + stack.pop().val);
                }

                System.out.println("-" + stack.pop().val);
            }
        }

        if(!stack.empty() && stack.peek()==g) {
            stack.pop();
        }


        System.out.println("stack size="+stack.size());
    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node0);
        node2.neighbors.add(node3);
        node3.neighbors.add(node3);

        System.out.println("DFS:");

        new DetectCycle().startDFS(node2);
    }
}