import java.util.*;

public class Kruskal {
    
    class Edge
    {
        int from;
        int to;
        int weight;
    }

    class ufdata
    {
        int parent;
        int rank;
    }

    int n;
    ufdata[] data;
    Edge[] edges;
    
    Kruskal(int n,int N)
    {
        this.n = n;
        edges = new Edge[N];
        for(int i = 0;i < N; i++)
            edges[i] = new Edge();

        data = new ufdata[n];
        for(int i = 0;i < n; i++)
            data[i] = new ufdata();

    }

    int find(int u) {
        if (data[u].parent == -1)
            return u;
        // path compression
        return data[u].parent = find(data[u].parent);
    }

    void union(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        // merge smaller height tree to bigger one
        if (data[pu].rank < data[v].rank) {
            data[pu].parent = pv;
        } else if (data[pu].rank < data[v].rank) {
            data[pv].parent = pu;
        } else {
            data[u].parent = pv;
            // inc rank of pointing to vertex
            data[pv].rank += 1;
        }
    }

    boolean Cycle(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        return pu == pv;
    }

    int mst() 
    {
        ArrayList<Edge> mstedges = new ArrayList<>();
        int mstweight = 0;

        // sort by weight
        Arrays.sort(edges, new Comparator<Edge>() {
            public int compare(Edge a, Edge b) {
                return a.weight - b.weight;
            }
        });

        for (int i = 0; i < edges.length && mstedges.size() < n-1; i++) {
            if (!Cycle(edges[i].from, edges[i].to)) {
                mstedges.add(edges[i]);
                union(edges[i].from, edges[i].to);
                mstweight += edges[i].weight;
            }
        }

        // print
        for (int i = 0; i < mstedges.size(); i++) {
            Edge e = mstedges.get(i);
            System.out.println(e.from + "\t->\t" + e.to + "\t" + e.weight);
        }

        return mstweight;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        int n = scan.nextInt();
        System.out.println("Enter the number of edges");
        int N = scan.nextInt();

        Kruskal k = new Kruskal(n,N);

        for (int i = 0; i < n; i++) {
            k.data[i].parent = -1;
            k.data[i].rank = 0;
        }

        System.out.println("Enter the edges");
        scan.nextLine();

        for (int i = 0; i < N; i++) {

            String[] input = scan.nextLine().split(" ");

            k.edges[i].from = Integer.parseInt(input[0]);
            k.edges[i].to = Integer.parseInt(input[1]);
            k.edges[i].weight = Integer.parseInt(input[2]);
        }

        System.out.println("\nMST");
        System.out.println();
        int mstweight = k.mst();
        System.out.println("\nMin Weight = \t" +mstweight);

        scan.close();
    }
}