import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation eines gewichteten Grpahen mit hilfe einer Adjazenzmatrix
 * 
 * @author Tarek Jakobeit, Tom Krause
 * @version Dezember 2018
 */
public class AdjazensmatrixD implements IGraphenD {
	
	private DijkstraKnoten[][] _adjazensmatrix;
	private int _graphenGroesse;
	private final static int START_GROESSE = 20;
	
	public AdjazensmatrixD() 
	{
		this(START_GROESSE);
	}
	
	public AdjazensmatrixD(int groesse)
	{
		_adjazensmatrix = new DijkstraKnoten[groesse][groesse];
		_graphenGroesse = groesse;
		int k =0;
		for(int i = 0;i< _graphenGroesse;++i) {
			for(int o = 0;o< _graphenGroesse;++o) {
				_adjazensmatrix[i][o]= new DijkstraKnoten(k);
				++k;
			}
		}
	}

	@Override
	public void setKnoten()
	{
		if(_graphenGroesse < _adjazensmatrix.length)
		{
		++_graphenGroesse;
		}
		else
		{
			Arrays.copyOf(_adjazensmatrix, _adjazensmatrix.length + 20);
			for(int i = 0; i < _adjazensmatrix.length; ++i)
			{
				Arrays.copyOf(_adjazensmatrix[i], _adjazensmatrix.length);		
			}
			++_graphenGroesse;
		}
	}

	@Override
	public void setKante(int startKnoten, int zielKnoten, int gewicht)
	{
		_adjazensmatrix[startKnoten][zielKnoten].addAdjazent(new Kante(_adjazensmatrix[zielKnoten][startKnoten], gewicht));
			
		
	}

	@Override
	public boolean traversieren(Knoten k)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Kante> getNachbarknoten(int knotenIndex)
	{
		for(int i = 0;i< _graphenGroesse;++i) {
			for(int o = 0;o< _graphenGroesse;++o) {
				if(_adjazensmatrix[i][o].getIndex()== knotenIndex) {
					return _adjazensmatrix[i][o].getAdjazenten();
				}
				
			}
		}
		
		return new HashSet<Kante>();
	}

	@Override
	public int getGewichtung(int knoten1, int knoten2)
	{
		for(Kante k : _adjazensmatrix[knoten1][knoten2].getAdjazenten()) {
			if(k.getZiel().getIndex()== knoten2) {
				return (int)k.getGewicht();
			}
		}
		return 0;
	}

	@Override
	public void DebugAusgabe()
	{
		for(int i = 0; i < _graphenGroesse; ++i)	
		{
			System.out.println();
			for(int j = 0; j < _graphenGroesse; ++j)
			{
				System.out.print(_adjazensmatrix[i][j].getIndex());				
			}
		}
	}
	
	

	@Override
	public int getGroesse()
	{
		return _graphenGroesse;
	}

	@Override
	public DijkstraKnoten getKnoten(int index)
	{
		for(int i = 0;i< _graphenGroesse;++i) {
			for(int o = 0;o< _graphenGroesse;++o) {
				if(_adjazensmatrix[i][o].getIndex()== index) {
					return _adjazensmatrix[i][o];
				}
				
			}
		}
		return null;
	}


}
