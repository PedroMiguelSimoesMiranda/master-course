import java.util.ArrayList;


public interface Graph {

	public void addEdge(int src, int dst, int w);
	
	public int getNumberNodes();
	
	public ArrayList<Edge> edges();
}
