import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implementation eines gewichteten Grpahen mit hilfe einer Adjazenzliste
 * 
 * @author Tarek Jakobeit, Tom Krause
 * @version Dezember 2018
 */
public class Adjazenzliste implements IGraphen
{
	private List<Map<Integer, Integer>>_adjazenzliste;
	
	public Adjazenzliste()
	{
		_adjazenzliste = new ArrayList<Map<Integer, Integer>>();
	}
	
	public Adjazenzliste(int groesse)
	{
		_adjazenzliste = new ArrayList<Map<Integer, Integer>>();
		for(int i = 1; i <= groesse; ++i)
		{
			setKnoten();
		}
	}
	
	@Override
	public void setKnoten()
	{
		Map<Integer, Integer> subMap = new HashMap<Integer, Integer>();
		_adjazenzliste.add(subMap);		
	}

	@Override
	public void setKante(int startKnoten, int zielKnoten, int gewicht)
	{
		_adjazenzliste.get(startKnoten).put(zielKnoten, gewicht);	
	}

	@Override
	public boolean traversieren(Knoten k)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Integer> getNachbarknoten(int knotenindex)
	{
		return _adjazenzliste.get(knotenindex).keySet();
	}

	@Override
	public int getGewichtung(int knoten1, int knoten2)
	{
		return _adjazenzliste.get(knoten1).get(knoten2);	
	}

	@Override
	public void DebugAusgabe()
	{
		for(int i = 0; i < _adjazenzliste.size(); ++i)
		{
			System.out.print("Von Knoten: " + i);
			for(Integer j : getNachbarknoten(i))
			{
				System.out.print(" zu Nachbar: " + j + " " + " Gewicht: " + getGewichtung(i, j));			
			}
			System.out.println();		
		}
	}
	
	public int getGroesse()
	{
		return _adjazenzliste.size();
	}

}
