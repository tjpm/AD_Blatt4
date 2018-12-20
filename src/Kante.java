
public class Kante
{
	private final DijkstraKnoten _ziel;
	private final double _gewicht;
    public Kante(DijkstraKnoten ziel, double gewicht)
    { 
    	_ziel = ziel; 
    	_gewicht = gewicht; 
    }
    public DijkstraKnoten getZiel() {
    	return _ziel;
    }
    public double getGewicht() {
    	return _gewicht;
    }
}

