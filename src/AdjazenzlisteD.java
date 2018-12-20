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
public class AdjazenzlisteD implements IGraphenD
{
	private List<DijkstraKnoten>_adjazenzliste;
	private int _groesse;
	public AdjazenzlisteD()
	{
		this(0);
	
	}
	
	public AdjazenzlisteD(int groesse)
	{
		_adjazenzliste = new ArrayList<DijkstraKnoten>();
		for(int i = 1; i <= groesse; ++i)
		{
			setKnoten();
		}
	}
	
	@Override
	public void setKnoten()
	{
		_adjazenzliste.add(new DijkstraKnoten(++_groesse));		
	}

	@Override
	public void setKante(int startKnoten, int zielKnoten, int gewicht)
	{
		_adjazenzliste.get(startKnoten).addAdjazent(new Kante(_adjazenzliste.get(zielKnoten), gewicht));	
	}

	@Override
	public boolean traversieren(Knoten k)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Kante> getNachbarknoten(int knotenindex)
	{
		return _adjazenzliste.get(knotenindex).getAdjazenten();
	}

	@Override
	public int getGewichtung(int knoten1, int knoten2)
	{
		for(Kante k : _adjazenzliste.get(knoten1).getAdjazenten()) {
			if(k.getZiel().getIndex()== knoten2) {
				return (int)k.getGewicht();
			}
		}
		return 0;	
	}

	@Override
	public void DebugAusgabe()
	{
		for(DijkstraKnoten dk :_adjazenzliste) {
			System.out.print(dk.getIndex()+": ");
			for(Kante k : dk.getAdjazenten()) {
				System.out.print(" zu Nachbar: " + k.getZiel().getIndex() + " " + " Gewicht: " + k.getGewicht());
			}
			System.out.println();
		}
	}
	
	public int getGroesse()
	{
		return _groesse;
	}

	@Override
	public DijkstraKnoten getKnoten(int index)
	{
		// TODO Auto-generated method stub
		return _adjazenzliste.get(index);
	}


}
