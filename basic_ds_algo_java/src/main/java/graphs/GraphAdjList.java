package graphs;

import java.util.LinkedList;
import java.util.List;

public class GraphAdjList {
    public int V; // number of vertices

    public List<Integer> adj[]; //Adjacency Lists

    public GraphAdjList(int v){
        V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }
}
