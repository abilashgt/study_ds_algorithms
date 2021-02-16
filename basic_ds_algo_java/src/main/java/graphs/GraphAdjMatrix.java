package graphs;

import java.util.LinkedList;
import java.util.List;

public class GraphAdjMatrix {
    public int V; // number of vertices
    public int E; // number of edges

    public Integer[][] adj; //Adjacency Lists

    public GraphAdjMatrix(int v){
        V = v;
        E = v;
        adj = new Integer[V][E];

        for(int i=0; i<V; i++){
            for(int j=0; j<E; j++) {
                adj[i][j] = 0;
            }
        }
    }

    public void addEdge(int v, int e){
        adj[v][e] = 1;
        //adj[e][v] = 1; // bidirectional
    }
}
