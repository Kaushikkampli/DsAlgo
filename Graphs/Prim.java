package Graphs;

public class Prim {
    
    int V;
    int key[];
    int parent[];
    boolean mst[];

    Prim(int v)
    {
        V = v;
        key = new int[V];
        parent = new int[V];
        mst = new boolean[V];

        for(int i = 0;i < V; i++)
        {
            mst[i] = false;
            key[i] = Integer.MAX_VALUE;
        }

        key[0] = 0;
    }

    int minedge()
    {
        int res = -1;
        int dist = Integer.MAX_VALUE;
        for(int v = 0;v < V; v++)
        {
            if(!mst[v] && key[v] < dist)
            {
                dist = key[v];
                res = v;
            }
        }

        return res;
    }

    void primmst(int[][] graph)
    {
        for(int count = 0;count < V; count++)
        {
            int u = minedge();
            System.out.println(u);

            mst[u] = true;

            for(int v = 0;v < V; v++)
            {
                if(!mst[v] && graph[u][v] != 0 && graph[u][v] < key[v])
                {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
    }

    void print(int[][] graph)
    {
        for(int v = 1;v < V; v++)
        {
            System.out.println(parent[v] +" - "+ v +" "+ graph[parent[v]][v]);
        }
    }

    public static void main(String[] args) {
        int v = 9;
        int graph[][] = new int[][] { {0,4,0,0,0,0,0,8,0},
                                        {4,0,8,0,0,0,0,11,0},
                                        {0,8,0,7,0,4,0,0,2},
                                        {0,0,7,0,9,14,0,0,0},
                                        {0,0,0,9,0,10,0,0,0},
                                        {0,0,4,14,10,0,2,0,0},
                                        {0,0,0,0,0,2,0,1,6},
                                        {8,11,0,0,0,0,1,0,7},
                                        {0,0,2,0,0,0,6,7,0}
        };
        
        Prim p = new Prim(v);
        p.primmst(graph);
        p.print(graph);
        
    }
}
