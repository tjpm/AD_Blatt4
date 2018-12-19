import java.util.Set;

/**
 * Ein Interface für Graphen mit entsprechendenn zugriffsfunktionen
 * 
 * @author Tarek Jakobeit, Tom Krause
 * @version Dezember 2018
 */
public interface IGraphen
{
	/** 
	 * fügt einen Knoten in den Graphen ein.
	 */
	public void setKnoten();

	/**
	 * fügt eine Kante in den Graphen ein
	 * @param start die Start position des Knoten von dem die Kante ausgeht
	 * @param ziel die Ziel position des Knoten auf den die Kante zeigt
	 * @param gewicht die Gewichtung der Kante
	 */
	public void setKante(int startKnoten, int zielKnoten, int gewicht);

	/**
	 * durchquert den Graphen
	 */
	public boolean traversieren(Knoten k);

	/**
	 * gibt den Nachbarknoten wieder 
	 */
	public Set<Integer> getNachbarknoten(int knotenIndex);
	
	/**
	 * gibt die Gewichtung des Graphen wieder
	 */
	public int getGewichtung(int knoten1, int knoten2);

	/**
	 * schreibt den Graphen auf die Konsole, zur debug Hilfe
	 */
	public void DebugAusgabe();

	/**
	 * Gibt die Anzahl der Knoten des Graphen zurück
	 */
	public int getGroesse();
}
