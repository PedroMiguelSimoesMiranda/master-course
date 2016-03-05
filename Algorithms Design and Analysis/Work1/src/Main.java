/**
 * Pedro Miguel Simões Miranda nº28289
 * Nuno Miguel de Brito Delgado nº28455
 */

import java.util.Scanner;

public class Main {
	
	public static int capacity;
	public static int n;
	public static Package[] packages;
	public static int[] acumulated;
	public static int[] acumdistances;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		capacity=in.nextInt();
		in.nextLine();
		n=in.nextInt();
		in.nextLine();
		packages = new Package[n+1];
		acumulated = new int[n+1];
		acumulated[0]=0;
		acumdistances = new int[n+1];
		acumdistances[0]=0;
		for(int i=1;i<=n;i++){
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();
			in.nextLine();
			packages[i] = new Package(x,y);
			acumulated[i]=acumulated[i-1]+w;
			if(i>1){
				acumdistances[i]=acumdistances[i-1]+cost(packages[i-1].x,packages[i-1].y,packages[i].x,packages[i].y);
			}
		}
		if(n==0)
			System.out.println(0);
		System.out.println(D(n));
	}
	
	public static int cost(int x1, int y1, int x2, int y2){
		return Math.abs(x1-x2)+ Math.abs(y1-y2);
	}
	
	public static int D(int p){
		int[] dists = new int[n+1];
		int i=0;
		for(i=1;i<=n;i++){
			if(w(1,i)<=capacity)
				dists[i]= cost(0,0,packages[1].x,packages[1].y)+d(1,i)+cost(0,0,packages[i].x,packages[i].y);
			else
				break;
		}
		for(int l=i;l<=n;l++){
			int k=0;
			int mindist=-1;
			while(w(l-k,l)<=capacity && l-k>=1){
				int dist = dists[l-k-1];
				dist+=cost(0,0,packages[l-k].x,packages[l-k].y)+d(l-k+1,l)+cost(0,0,packages[l].x,packages[l].y);
				if(mindist==-1 || dist<mindist)
					mindist=dist;
				k++;
			}
			dists[l]= mindist;
		}
		return dists[p];
	}
	
	public static int w(int i,int j){
		return acumulated[j]-acumulated[i-1];
	}
	
	public static int d(int i, int j){
		return acumdistances[j]-acumdistances[i-1];
	}
}