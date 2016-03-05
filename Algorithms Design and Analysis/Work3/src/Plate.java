
public class Plate {
	private boolean[] paths;
	private boolean[] explored;
	
	public Plate(boolean[] paths){
		this.paths=paths;
		this.explored=new boolean[4];
	}
	
	public boolean isExplored(int c){
		return explored[c];
	}
	
	public void explore(int c){
		explored[c]=true;
	}
	
	public boolean[] getPaths(){
		return paths;
	}
}
