
public class Edge implements Comparable<Edge>{
	private int src,dst,weight;
	
	public Edge(int src, int dst, int w){
		this.src=src;
		this.dst=dst;
		this.weight=w;
	}
	
	public int getSource(){
		return this.src;
	}
	public int getDest(){
		return this.dst;
	}
	public int getWeight(){
		return this.weight;
	}

	public int[] endVertices(){ // end vertices 
		int[] vs = new int[2];
		vs[0]=src;
		vs[1]=dst;
		return vs;
	}

	@Override
	public int compareTo(Edge arg0) {
		return arg0.weight-this.weight;
	}
}
