import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Visualisierung
{
	
	public static void main(String args[]) throws IOException
	{
		Adjazensmatrix adjazensmatrix;
		Adjazenzliste adjazensliste;
		
	    adjazensmatrix = new Adjazensmatrix(5);
	    adjazensliste = new Adjazenzliste(5);
	    
	    
		
		adjazensliste.setKante(4, 1, 9);
		adjazensliste.setKante(3, 4, 8);
		adjazensliste.setKante(2, 3, 7);
		adjazensliste.setKante(1, 2, 6);
		adjazensliste.setKante(0, 1, 5);
		
		adjazensmatrix.setKante(4, 1, 9);
		adjazensmatrix.setKante(3, 4, 8);
		adjazensmatrix.setKante(2, 3, 7);
		adjazensmatrix.setKante(1, 2, 6);
		adjazensmatrix.setKante(0, 1, 5);
		
		KuerzesteWegeMitDijkstra also = new KuerzesteWegeMitDijkstra(adjazensliste);    
	    adjazensmatrix.DebugAusgabe();	
	    System.out.println();
	    adjazensliste.DebugAusgabe();
	    InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.print("Gib den Knoten für die kürzesten Wege ein: ");
	    int eingabe = Integer.parseInt(br.readLine());
	    Map<Integer, Integer> af = also.ermittleKuerzestenWege(eingabe);
	    Integer vorgaenger = eingabe;
	    for(Integer i : af.keySet()) {
	    	if(i==eingabe) {
	    		vorgaenger = i;
	    	}
	    	System.out.println("von "+ vorgaenger +" nach " + i + " braucht es: " + af.get(i));
	    	vorgaenger = i;
	    }
	}
	
}
