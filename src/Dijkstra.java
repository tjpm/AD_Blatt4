import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra
{
	private IGraphenD _graph;
	public Dijkstra(IGraphenD graph) {
		_graph =graph;
	}
	public void computePaths(int index)
    {
        _graph.getKnoten(index).minDistance = 0.;
        PriorityQueue<DijkstraKnoten> vertexQueue = new PriorityQueue<DijkstraKnoten>();
        vertexQueue.add(_graph.getKnoten(index));

        while (!vertexQueue.isEmpty()) {
            DijkstraKnoten u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Kante e : u.getAdjazenten())
            {
                DijkstraKnoten v = e.getZiel();
                double weight = e.getGewicht();
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.setVorgaenger(u);
                    vertexQueue.add(v);
                }
            }
        }
    }
	public static void computePaths(DijkstraKnoten source)
    {
        source.minDistance = 0.;
        PriorityQueue<DijkstraKnoten> vertexQueue = new PriorityQueue<DijkstraKnoten>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            DijkstraKnoten u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Kante e : u.getAdjazenten())
            {
                DijkstraKnoten v = e.getZiel();
                double weight = e.getGewicht();
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.setVorgaenger(u);
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<DijkstraKnoten> getShortestPathTo(DijkstraKnoten target)
    {
        List<DijkstraKnoten> path = new ArrayList<DijkstraKnoten>();
        for (DijkstraKnoten vertex = target; vertex != null; vertex = vertex.getVorgaenger())
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices 
        DijkstraKnoten A = new DijkstraKnoten(0);
        DijkstraKnoten B = new DijkstraKnoten(1);
        DijkstraKnoten D = new DijkstraKnoten(2);
        DijkstraKnoten F = new DijkstraKnoten(3);
        DijkstraKnoten K = new DijkstraKnoten(4);
        DijkstraKnoten J = new DijkstraKnoten(5);
        DijkstraKnoten M = new DijkstraKnoten(6);
        DijkstraKnoten O = new DijkstraKnoten(7);
        DijkstraKnoten P = new DijkstraKnoten(8);
        DijkstraKnoten R = new DijkstraKnoten(9);
        DijkstraKnoten Z = new DijkstraKnoten(10);

        // set the edges and weight
        A.addAdjazent(new Kante(M, 8)); 
        B.addAdjazent(new Kante(D, 11));
        D.addAdjazent(new Kante(B, 11));
        F.addAdjazent(new Kante(K, 23));
        K.addAdjazent(new Kante(O, 40));
        J.addAdjazent(new Kante(K, 25));
        M.addAdjazent(new Kante(R, 8));
        O.addAdjazent(new Kante(K, 40));
        P.addAdjazent(new Kante(Z, 18));
        R.addAdjazent(new Kante(P, 15));
        Z.addAdjazent(new Kante(P, 18));


        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<DijkstraKnoten> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }
}
