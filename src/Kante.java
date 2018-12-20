
public class Kante
{
	private final DijkstraKnoten _ziel;
	private final int _gewicht;
    public Kante(DijkstraKnoten ziel, int gewicht)
    { 
    	_ziel = ziel; 
    	_gewicht = gewicht; 
    }
    public DijkstraKnoten getZiel() {
    	return _ziel;
    }
    public int getGewicht() {
    	return _gewicht;
    }
}

