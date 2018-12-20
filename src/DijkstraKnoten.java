import java.util.HashSet;
import java.util.Set;

class DijkstraKnoten implements Comparable<DijkstraKnoten>
{
	private final int _index;
    private Set<Kante> _adjazenten;
    public double minDistance = Double.POSITIVE_INFINITY;
    private DijkstraKnoten _vorgaenger;
    
    public DijkstraKnoten(int index) { 
    	_index = index; 
    	_adjazenten = new HashSet<Kante>();
    }
    public String toString() { 
    	return Integer.toString(_index); 
    }
    public int compareTo(DijkstraKnoten other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    public Set<Kante> getAdjazenten() {
    	return _adjazenten;
    }
    public int getIndex() {
    	return _index;
    }
    public DijkstraKnoten getVorgaenger() {
    	return _vorgaenger;
    }
    public double getMinDistance() {
    	return minDistance;
    }
    public void setVorgaenger(DijkstraKnoten v) {
    	_vorgaenger = v;
    }
    public void addAdjazent(Kante k) {
    	_adjazenten.add(k);
    }
}
