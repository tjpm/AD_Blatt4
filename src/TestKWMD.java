import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
/**
 * Testklasse für den Algorithmus von Dijkstra
 * 
 * @author Tarek Jakobeit, Tom Krause
 * @version Dezember 2018
 */
public class TestKWMD
{
	private IGraphen _graph;
	private int _graphGroesse;
	private int _dijkstraStart;
	public TestKWMD() {
		_graphGroesse = (int) Math.pow(10, 1);
		_dijkstraStart = 5;
		_graph = new Adjazenzliste(_graphGroesse);
	}
	@Test
	public void testeDijkstra() {
		generiereGraph();
		_graph.DebugAusgabe();
		assertEquals(_graph.getGroesse(),_graphGroesse);
		KuerzesteWegeMitDijkstra dijkstra = new KuerzesteWegeMitDijkstra(_graph);
		Map<Integer, Integer> kurzeWege = dijkstra.ermittleKuerzestenWege(_dijkstraStart);
		System.out.println("Dikjstras kürzeste Wege:");
		Integer vorgaenger = _dijkstraStart;
	    for(Integer i : kurzeWege.keySet()) {
//	    	if(i==_dijkstraStart) {
//	    		vorgaenger = i;
//	    	}
	    	System.out.println("von "+ vorgaenger +" nach " + i + " braucht es: " + kurzeWege.get(i));
	    	vorgaenger = i;
	    }
	}
	private void generiereGraph() {
		for(int i= 0; i< _graphGroesse;++i) {
			_graph.setKante((int)(Math.random() * _graphGroesse), (int)(Math.random() * _graphGroesse), (int)(Math.random() * 10));
		}
	}
}
