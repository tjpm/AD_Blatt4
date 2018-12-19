import java.util.HashMap;
import java.util.Map;

/**
 * Implementation eines Knotens für die 
 * gewichteten Grpahen
 * 
 * @author Tarek Jakobeit, Tom Krause
 * @version Dezember 2018
 */
public class Knoten
{
	private int _index;
	private Map<Integer, Integer> _nachbarknoten;
	
	public Knoten(int index)
	{
		_index = index; 
		_nachbarknoten = new HashMap<Integer, Integer>();
	}
	
	public int gibIndex()
	{
		return _index;
	}
	
	public void fuegeNachbarknotenHinzu(Integer knoten, int abstand)
	{
		_nachbarknoten.put(knoten, abstand);		
	}

}
