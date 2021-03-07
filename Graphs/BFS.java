package Graphs;

import java.util.*;

class BFS 
{
    static int V;
    static ArrayList<ArrayList<Integer> > adj;

    BFS(int v)
    {
        V = v;
        adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int v,int w)
    {
        adj.get(v).add(w);
    }

    void bfs(int s)
    {
        Queue<Integer> q= new LinkedList<>();
        q.add(s);

        boolean visited[] = new boolean[V];
        visited[s] = true;
        System.out.print(s +" -> ");

        while(q.size() != 0)
        {
            int ver = q.remove();
            for(int i = 0; i < adj.get(ver).size(); i++)
            {
                int v = adj.get(ver).get(i);
                if(visited[v] == false)
                {
                    visited[v] = true;
                    q.add(v);
                    System.out.print(v +" -> ");
                }
            }
        }

    }

    public static void main(String[] args) 
    {
        int n;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");

        n = scan.nextInt();
        BFS b = new BFS(n);

        b.addEdge(0, 1); 
        b.addEdge(0, 2); 
        b.addEdge(1, 2); 
        b.addEdge(2, 0); 
        b.addEdge(2, 3); 
        b.addEdge(3, 3);

        b.bfs(2);

        scan.close();
    }    
}