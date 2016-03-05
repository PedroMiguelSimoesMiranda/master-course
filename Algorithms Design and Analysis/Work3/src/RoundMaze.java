import java.util.LinkedList;
import java.util.Queue;


public class RoundMaze {
	private int R;
	private int C;
	private Plate[][] maze;
	
	public RoundMaze(int R, int C){
		this.R=R;
		this.C=C;
		maze = new Plate[R+1][C+1];
	}
	
	public void createPlate(String dirs, int r, int c){
		boolean[] paths = new boolean[4];
		for(int i=0;i<dirs.length();i++){
			switch(dirs.charAt(i))
			{
			case 'N':
				paths[0]=true;
				break;
			case 'E':
				paths[3]=true;
				break;
			case 'S':
				paths[2]=true;
				break;
			case 'W':
				paths[1]=true;
				break;
			default: 
			}
		}
		maze[r][c]= new Plate(paths);
	}
	
	public String findMinCost(Node root, Node goal){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		maze[root.r][root.c].explore(0);
		
		while(!q.isEmpty()){
			Node n = q.poll();
			maze[n.r][n.c].explore((n.cost)%4);
			
			if(n.c==goal.c && n.r==goal.r)
				return ""+n.cost;
			for(Node s: n.successors(maze,R,C)){
				if(s.c==goal.c && s.r==goal.r)
					return ""+s.cost;
				maze[s.r][s.c].explore(s.cost%4);
				q.add(s);
			}
		}
		return "no path to exit";
	}
}
