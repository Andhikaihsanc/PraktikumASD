import java.io.*;
import java.util.*;


class Graphh {
    private int g; 
    private LinkedList<Integer> adj[];
 
    @SuppressWarnings("unchecked") Graphh(int g)
    {
        g = g;
        adj = new LinkedList[g];
        for (int i = 0; i < g; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
 
    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");
 
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    void DFS(int v)
    {
        boolean visited[] = new boolean[g];
 
        DFSUtil(v, visited);
    }

    void BFS(int s)
    {
      
        boolean visited[] = new boolean[g];
 
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int a = i.next();
                if (!visited[a])
                {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}



public class Solution {
    public static void main(String args[])
    {
        Graphh g = new Graphh(6);
 
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 1);
 
        g.DFS(1);
        System.out.println("");
        g.BFS(1);
    }
}

