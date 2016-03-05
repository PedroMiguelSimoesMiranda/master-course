import java.util.LinkedList;
import java.util.List;

public class Node {	
	int c;
	int r;
	int cost;
	
	public Node(int r, int c, int cost){
		this.c=c;
		this.r=r;
		this.cost=cost;
	}
	
	public List<Node> successors(Plate[][] maze, int R, int C){
		List<Node> suc = new LinkedList<Node>();
		boolean[] paths = maze[r][c].getPaths();
		
		int NORTH  = cost%4;
		int EAST = (NORTH+3)%4;
		int SOUTH =(NORTH+2)%4;
		int WEST = (NORTH+1)%4;
		
		int newCost = (cost+1)%4;
		
		if(paths[NORTH] && r-1>=1 && !maze[r-1][c].isExplored(newCost))
			suc.add(new Node(r-1,c,cost+1));
		if(paths[SOUTH] && r+1<=R && !maze[r+1][c].isExplored(newCost))
			suc.add(new Node(r+1,c,cost+1));
		if(paths[EAST] && c+1<=C && !maze[r][c+1].isExplored(newCost))
			suc.add(new Node(r,c+1,cost+1));
		if(paths[WEST] && c-1>=1 && !maze[r][c-1].isExplored(newCost))
			suc.add(new Node(r,c-1,cost+1));
		
		return suc;
	}
}
