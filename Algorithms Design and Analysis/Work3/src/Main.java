import java.util.Scanner;
/**
 * Trabalho realizado por:
 * Pedro Miguel Simões Miranda nº28289
 * Nuno Miguel de Brito Delgado nº28455
 */

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int C = in.nextInt();
		
		in.nextLine();
		
		RoundMaze rm = new RoundMaze(R,C);
		
		for(int i=1;i<R+1;i++)
			for(int j=1;j<C+1;j++){
				if(i==R && j==C)
					rm.createPlate("",i,j);
				else
				{
					String dirs = in.nextLine();
					rm.createPlate(dirs,i,j);
				}
			}
		System.out.println(rm.findMinCost(new Node(1,1,0), new Node(R,C,-1)));
	}
	
	
}
