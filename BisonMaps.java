
public class BisonMaps {

    public static void main(String[] args) {

        // read in the graph from a file
        In graphin = new In(args[0]);
        //Declares a variable from the class Eucliedean Graph and calls on the constructor
        EuclideanGraph G = new EuclideanGraph(graphin);
        //Reads the graph and prints out the following:
        System.err.println("Done reading the graph " + args[0]);
        System.err.println("Enter query pairs from stdin");

        // read in the s-d pairs from standard input
        Dijkstra dijkstra = new Dijkstra(G);
       //If the points s and d is in the mapfile dijsktra show path is called and it reads
        // the way from point s to point d.
        while(!StdIn.isEmpty()) {
            int s = StdIn.readInt();
            int d = StdIn.readInt();
            dijkstra.showPath(s, d);
            System.out.println();
        }
    }
}
