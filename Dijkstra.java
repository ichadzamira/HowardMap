
public class Dijkstra {
    private static double INFINITY = Double.MAX_VALUE;
    private static double EPSILON  = 0.000001;

    private EuclideanGraph G;
    private double[] dist;
    private int[] pred;
    
    //constructor
    public Dijkstra(EuclideanGraph G) {
        this.G = G;
    }

    // return shortest path distance from s to d
    public double distance(int s, int d) {
        dijkstra(s, d);
        return dist[d];
    }

    // print shortest path from s to d  (interchange s and d to print in right order)
    public void showPath(int d, int s) {
        dijkstra(s, d);
        if (pred[d] == -1) {
            System.out.println(d + " is unreachable from " + s);
            return;
        }
        for (int v = d; v != s; v = pred[v])
            System.out.print(v + "-");
        System.out.println(s);
    }

    // Dijkstra's algorithm to find shortest path from s to d
    private void dijkstra(int s, int d) {
        //Sets V to the number of vertices
    	int V = G.V();

        // initialize
        dist = new double[V];
        pred = new int[V];
        for (int v = 0; v < V; v++) dist[v] = INFINITY;
        for (int v = 0; v < V; v++) pred[v] = -1;

        // priority queue
        IndexPQ pq = new IndexPQ(V);
        for (int v = 0; v < V; v++) pq.insert(v, dist[v]);

        // set distance of source
        dist[s] = 0.0;
        pred[s] = s;
        pq.change(s, dist[s]);

        // run Dijkstra's algorithm
        while (!pq.isEmpty()) {
        	//Calls the IndexPQ method of deleting and returning the minimum element
            int v = pq.delMin();
            //// System.out.println("process " + v + " " + dist[v]);

            // v not reachable from s so stop
            if (pred[v] == -1) break;

            // scan through all nodes w adjacent to v
            IntIterator i = G.neighbors(v);
            while (i.hasNext()) {
                int w = i.next();
                //if distance of v + the Euclidean distance of v and w is less of distance of w 
                if (dist[v] + G.distance(v, w) < dist[w] - EPSILON) {
                	//distance of w will equal distance of v + the euclidean distance of v and w
                    dist[w] = dist[v] + G.distance(v, w);
                    pq.change(w, dist[w]);
                    pred[w] = v;
                    //// System.out.println("    lower " + w + " to " + dist[w]);
                }
            }
        }
    }


}

