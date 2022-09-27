package graphs.search;

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

import graphs.GraphAdjMatrix;

public class DepthFirstSearchByAdjMatrix {

    public static void startDFS(GraphAdjMatrix g, int v){
        boolean visited[] = new boolean[g.V];
        SearchDFS(g, v, visited);
    }

    public static void SearchDFS(GraphAdjMatrix g, int v, boolean[] visited){
        System.out.print(v+" ");
        visited[v] = true;

        for(int i=0; i<g.E; i++){
            if(g.adj[v][i] == 1 && !visited[i]){
                SearchDFS(g, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjMatrix g = new GraphAdjMatrix(4);

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