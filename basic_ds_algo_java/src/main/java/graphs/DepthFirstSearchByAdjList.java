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

public class DepthFirstSearchByAdjList {

    public static void startDFS(GraphAdjList g, int v){
        boolean visited[] = new boolean[g.V];
        SearchDFS(g, v, visited);
    }

    public static void SearchDFS(GraphAdjList g, int v, boolean[] visited){
        visited[v] = true;

        System.out.print(v+" ");

        for(int n: g.adj[v]){
            System.out.print(n);
            if(!visited[n]){
                //SearchDFS(g, n, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjList g = new GraphAdjList(4);

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