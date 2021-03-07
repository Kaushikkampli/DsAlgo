package Graphs;
import java.util.*;
class DFS
{
    static int V;
    static ArrayList<ArrayList<Integer> > adj;
    static boolean[] visited;

    DFS(int v)
    {
        V = v;
        adj = new ArrayList<>(V);
        visited = new boolean[V];
        for(int i = 0;i < V; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int v,int w)
    {
        adj.get(v).add(w);
    }

    static void dfs(int s)
    {
        visited[s] = true;
        System.out.print(s +" -> ");
    
        for(int i = 0;i < adj.get(s).size(); i++)
        {
            int ver = adj.get(s).get(i);
            if(visited[ver] == false)
            {
                visited[ver] = true;
                dfs(ver);
            }
        }
    }
    public static void main(String[] args) 
    {
        int n;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = scan.nextInt();

        DFS g = new DFS(n);
        
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
         
        System.out.println(adj);
        dfs(2);
        
        scan.close();
    }
}