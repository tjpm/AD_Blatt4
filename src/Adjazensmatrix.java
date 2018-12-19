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
public class Adjazensmatrix implements IGraphen {
	
	private int[][] _adjazensmatrix;
	private int _graphenGroesse;
	private final static int START_GROESSE = 20;
	
	public Adjazensmatrix() 
	{
		this(START_GROESSE);
	}
	
	public Adjazensmatrix(int groesse)
	{
		_adjazensmatrix = new int[groesse][groesse];
		_graphenGroesse = groesse;
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
		_adjazensmatrix[startKnoten][zielKnoten] = gewicht;	
	}

	@Override
	public boolean traversieren(Knoten k)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Integer> getNachbarknoten(int knotenIndex)
	{
		Set<Integer> nachbarknoten = new HashSet<Integer>();
		for(int i = 0; i < _adjazensmatrix[knotenIndex].length; ++i)
		{
			if(_adjazensmatrix[knotenIndex][i] != 0)
			{
				nachbarknoten.add(i);
			}	
		}
		return nachbarknoten;
	}

	@Override
	public int getGewichtung(int knoten1, int knoten2)
	{
		return _adjazensmatrix[knoten1][knoten2];
	}

	@Override
	public void DebugAusgabe()
	{
		for(int i = 0; i < _graphenGroesse; ++i)	
		{
			System.out.println();
			for(int j = 0; j < _graphenGroesse; ++j)
			{
				System.out.print(_adjazensmatrix[i][j]);				
			}
		}
	}
	
	

	@Override
	public int getGroesse()
	{
		return _graphenGroesse;
	}

}
