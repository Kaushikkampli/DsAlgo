package Graphs;
import java.util.*;

public class SCC
{
    static int V;
    
    static ArrayList<ArrayList<Integer> > adj;
    static ArrayList<ArrayList<Integer> > tr;

    static boolean visited[];
    static Stack<Integer> S = new Stack<>();

    SCC(int n)
    {
        V = n;
        adj = new ArrayList<>();
        tr = new ArrayList<>();

        visited = new boolean[V];
        for(int i = 0;i < n; i++)
        {
            adj.add(new ArrayList<Integer>(V));
            tr.add(new ArrayList<Integer>(V));
        }
    }
 
    void addEdge(int u,int v)
    {
        adj.get(u).add(v);
    }

    void traddEdge(int u,int v)
    {
        tr.get(u).add(v);
    }

    void getTranspose()
    {
        for(int i = 0;i < adj.size(); i++)
        {
            for(int j = 0; j < adj.get(i).size(); j++)
                traddEdge(adj.get(i).get(j), i);
        }
    }

    void dfs(int s)
    {
        visited[s] = true;
        
        System.out.print(s);
        for(int i = 0;i < adj.get(s).size(); i++)
        {
            int ver = adj.get(s).get(i);
            if(!visited[ver])
                dfs(ver);
        }

        S.push(s);
    }

    void computeScc()
    {
        for(int i =0; i < V; i++)
        {
            visited[i] = false;
        }

        while(!S.empty())
        {
            int ver = S.pop();
            if(!visited[ver])
            {
                dfs(ver);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) 
    {
        int n;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = scan.nextInt();

        SCC g = new SCC(n);

        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 4);

        System.out.println(adj);

        g.dfs(0);

        g.getTranspose();
        System.out.println(tr);
        adj = tr;

        g.computeScc();
        scan.close();
    }
}