import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
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
	private List<Integer> _makierteKnoten;
	private Map<Integer, Integer> _data;
	private List<Integer> _bisherigeKnoten;
	private Map<Map<Integer, ArrayList<Integer>>, Integer> _kkuerzesteWege;
	private ArrayList<Integer> nList;
	private Queue<Integer> _qw;
	private Map<Integer, ArrayList<Integer>> _nochneMap;
	public KuerzesteWegeMitDijkstra(IGraphen graph)
	{
		_qw = new PriorityQueue<Integer>();
		_graph = graph;		
		_kuerzesteWege = new HashMap<Integer, Integer>();
		_makierteKnoten = new ArrayList<Integer>();
		_data = new HashMap<Integer, Integer>();
		_bisherigeKnoten = new ArrayList<Integer>();
		nList = new ArrayList<Integer>();
		_nochneMap =new HashMap<Integer, ArrayList<Integer>>();
		_kkuerzesteWege = new HashMap<Map<Integer, ArrayList<Integer>>, Integer>();
	}
	//TODO https://stackoverflow.com/questions/17480022/java-find-shortest-path-between-2-points-in-a-distance-weighted-map
	public Map<Integer, Integer> ermittleKuerzestenWege(int startKnoten)
	{
		int bisherigeDistanz;
		_qw.add(startKnoten);
		nList.add(startKnoten);
		_kuerzesteWege.put(startKnoten, 0);
		
		while(_makierteKnoten.size() < _graph.getGroesse() && !_makierteKnoten.contains(startKnoten))
		{
		bisherigeDistanz = _kuerzesteWege.get(startKnoten);
		setzeAbstaende(startKnoten, bisherigeDistanz);
		_makierteKnoten.add(startKnoten);
		startKnoten = gibNaehestenKnoten(startKnoten);
		}		
		return _kuerzesteWege;
	}
	
	private void setzeAbstaende(int aktuellerKnoten, int bisherigeDistanz)
	{
		int distanz;
		
		
		for(Integer knoten : _graph.getNachbarknoten(aktuellerKnoten))
		{
			
				distanz = _graph.getGewichtung(aktuellerKnoten, knoten);
				if(!_kuerzesteWege.containsKey(knoten) 
						|| (_kuerzesteWege.containsKey(knoten) && (bisherigeDistanz + distanz) < _kuerzesteWege.get(knoten)))
				{
					//_bisherigeDistanz.add(knoten);
					//map startknoten,list(knoten)
					ArrayList<Integer> list = _nochneMap.get(aktuellerKnoten);
					if (list == null) {
						list = new ArrayList<Integer>();
					}
					list.add(knoten);
					_nochneMap.put(aktuellerKnoten, list);
					//aktuellerKnoten.setVorgaenger(knoten.intValue());
					_kuerzesteWege.put(knoten, bisherigeDistanz + distanz);
				}
				_data.put(knoten, distanz);
				
		}		
		//_bisherigeDistanz.add(bisherigeDistanz);
	}
	public Map<Integer, Integer> getData(){
		return _data;
	}
	public Map<Integer, ArrayList<Integer>> getmap(){
		return _nochneMap;
	}
	public List<Integer> getBisherigeKnoten(){
		return _bisherigeKnoten;
	}
	public List<Integer> makierteKnoten(){
		return _makierteKnoten;
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
		_bisherigeKnoten.add(naechsterKnoten);
		return naechsterKnoten;
	}
	

}
