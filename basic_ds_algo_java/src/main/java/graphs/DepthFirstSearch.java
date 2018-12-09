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

public class DepthFirstSearch {

    public static void startDFS(Graph g, int v){
        boolean visited[] = new boolean[g.V];
        SearchDFS(g, v, visited);
    }

    public static void SearchDFS(Graph g, int v, boolean[] visited){
        visited[v] = true;

        System.out.print(v+" ");

        for(int n: g.adj[v]){
            if(!visited[n]){
                SearchDFS(g, n, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS:");

        startDFS(g, 2);
    }
}