


class DijkstraKnoten implements Comparable<DijkstraKnoten>
{
    public final String name;
    public Kante[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public DijkstraKnoten previous;
    public DijkstraKnoten(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(DijkstraKnoten other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}
