import java.util.*;

class Dijkstra
{
    static int V;
    static ArrayList<ArrayList<Integer> > adj;
    static ArrayList<ArrayList<Integer> > weight;

    static boolean[] sptSet;
    static int[] dist;

    Dijkstra(int v)
    {
        V = v;
        adj = new ArrayList<>();
        weight = new ArrayList<>();

        sptSet = new boolean[V];
        dist = new int[V];

        for(int  i = 0;i < V; i++)
        {
            adj.add(new ArrayList<Integer>());
            weight.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int u,int v,int wt)
    {
        adj.get(u).add(v);
        weight.get(u).add(wt);

        adj.get(v).add(u);
        weight.get(v).add(wt);
    }

    int minDist()
    {
        int min = Integer.MAX_VALUE;
        int ind  = -1;

        for(int i = 0; i < V; i++)
        {  
            if(sptSet[i] == false && dist[i] < min)
            {
                min = dist[i];
                ind = i;
            }
        }
        return ind;
    }

    void dijkstra(int src)
    {
        int ind;
        for(int i = 0;i < V; i++)
        {
            sptSet[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[src] = 0;
            
        for(int v = 0; v < V - 1; v++)
        {
            int u = minDist();
            sptSet[u] = true;

            for(int i = 0; i < adj.get(u).size(); i++)
            {
                ind = adj.get(u).get(i);
                if(!sptSet[ind] && dist[ind] == Integer.MAX_VALUE && dist[u] + weight.get(u).get(i) < dist[ind])
                    dist[ind] = dist[u] + weight.get(u).get(i);
            }
        }
    }

    void printSolution()
    {
        for(int i = 0;i < V; i++)
            System.out.println(i+": " +dist[i]);
    }

    public static void main(String[] args) {
        
        int n;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        n = scan.nextInt();
        
        Dijkstra dic = new Dijkstra(n);

        dic.addEdge(0, 1, 4); 
        dic.addEdge(0, 7, 8); 
        dic.addEdge(1, 2, 8); 
        dic.addEdge(1, 7, 11); 
        dic.addEdge(2, 3, 7); 
        dic.addEdge(2, 8, 2); 
        dic.addEdge(2, 5, 4); 
        dic.addEdge(3, 4, 9); 
        dic.addEdge(3, 5, 14); 
        dic.addEdge(4, 5, 10); 
        dic.addEdge(5, 6, 2); 
        dic.addEdge(6, 7, 1); 
        dic.addEdge(6, 8, 6); 
        dic.addEdge(7, 8, 7);
        System.out.println(adj);
        System.out.println(weight);

        scan.close();

        dic.dijkstra(0);

        dic.printSolution();
        
    }
}