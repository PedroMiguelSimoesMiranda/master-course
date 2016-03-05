import java.util.ArrayList;

public class GraphImpl implements Graph {
	private int nv;
	private ArrayList<Edge> edges;
	
	public GraphImpl( int n){
		this.nv=n;
		edges = new ArrayList<Edge>();
	}
	
	public void addEdge(int src, int dst, int w){
		edges.add(new Edge(src,dst,w));
	}
	
	public int getNumberNodes(){
		return nv;
	}
	
	public ArrayList<Edge> edges(){
		return edges;
	}
}
