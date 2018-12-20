import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra
{
	public static void computePaths(DijkstraKnoten source)
    {
        source.minDistance = 0.;
        PriorityQueue<DijkstraKnoten> vertexQueue = new PriorityQueue<DijkstraKnoten>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            DijkstraKnoten u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Kante e : u.adjacencies)
            {
                DijkstraKnoten v = e.getZiel();
                double weight = e.getGewicht();
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<DijkstraKnoten> getShortestPathTo(DijkstraKnoten target)
    {
        List<DijkstraKnoten> path = new ArrayList<DijkstraKnoten>();
        for (DijkstraKnoten vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        DijkstraKnoten A = new DijkstraKnoten("A");
        DijkstraKnoten B = new DijkstraKnoten("B");
        DijkstraKnoten D = new DijkstraKnoten("D");
        DijkstraKnoten F = new DijkstraKnoten("F");
        DijkstraKnoten K = new DijkstraKnoten("K");
        DijkstraKnoten J = new DijkstraKnoten("J");
        DijkstraKnoten M = new DijkstraKnoten("M");
        DijkstraKnoten O = new DijkstraKnoten("O");
        DijkstraKnoten P = new DijkstraKnoten("P");
        DijkstraKnoten R = new DijkstraKnoten("R");
        DijkstraKnoten Z = new DijkstraKnoten("Z");

        // set the edges and weight
        A.adjacencies = new Kante[]{ new Kante(M, 8) };
        B.adjacencies = new Kante[]{ new Kante(D, 11) };
        D.adjacencies = new Kante[]{ new Kante(B, 11) };
        F.adjacencies = new Kante[]{ new Kante(K, 23) };
        K.adjacencies = new Kante[]{ new Kante(O, 40) };
        J.adjacencies = new Kante[]{ new Kante(K, 25) };
        M.adjacencies = new Kante[]{ new Kante(R, 8) };
        O.adjacencies = new Kante[]{ new Kante(K, 40) };
        P.adjacencies = new Kante[]{ new Kante(Z, 18) };
        R.adjacencies = new Kante[]{ new Kante(P, 15) };
        Z.adjacencies = new Kante[]{ new Kante(P, 18) };


        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<DijkstraKnoten> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }
}
