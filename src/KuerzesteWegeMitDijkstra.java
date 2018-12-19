import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Implementation des Dijkstraalgorithmus der kürzesten Wege
 * 
 * @author Tarek Jakobeit, Tom Krause
 * @version Dezember 2018
 */
public class KuerzesteWegeMitDijkstra
{
	private IGraphen _graph;
	private Map<Integer, Integer> _kuerzesteWege;
	private Set<Integer> _makierteKnoten;
	
	public KuerzesteWegeMitDijkstra(IGraphen graph)
	{
		_graph = graph;		
		_kuerzesteWege = new HashMap<Integer, Integer>();
		_makierteKnoten = new HashSet<Integer>();
	}
	
	public Map<Integer, Integer> ermittleKuerzestenWege(int startKnoten)
	{
		int bisherigeDistanz;
		_kuerzesteWege.put(startKnoten, 0);
		
		while(_makierteKnoten.size() < _graph.getGroesse() && !_makierteKnoten.contains(startKnoten))
		{
		bisherigeDistanz = _kuerzesteWege.get(startKnoten);
		setzeAbstaende(startKnoten, bisherigeDistanz);
		_makierteKnoten.add(startKnoten);
		startKnoten = gibNaehestenKnoten(startKnoten);
		}		
		for(Integer i:_makierteKnoten) {
			System.out.println(i);
		}
		return _kuerzesteWege;
	}
	
	private void setzeAbstaende(int startKnoten, int bisherigeDistanz)
	{
		int distanz;
		for(Integer knoten : _graph.getNachbarknoten(startKnoten))
		{
				distanz = _graph.getGewichtung(startKnoten, knoten);
				if(!_kuerzesteWege.containsKey(knoten) 
						|| (_kuerzesteWege.containsKey(knoten) && (bisherigeDistanz + distanz) < _kuerzesteWege.get(knoten)))
				{
				_kuerzesteWege.put(knoten, bisherigeDistanz + distanz);
				}
		}			
	}
	
	private int gibNaehestenKnoten(int startKnoten)
	{
		int distanz;
		int naechsterKnoten = startKnoten;
		int kleinsteDistanz = Integer.MAX_VALUE;
		for(Integer knoten : _kuerzesteWege.keySet())	
		{
			distanz = _kuerzesteWege.get(knoten);
			if(!_makierteKnoten.contains(knoten) && distanz < kleinsteDistanz)
			{
				naechsterKnoten = knoten;			
			}
		}
		return naechsterKnoten;
	}
	

}
