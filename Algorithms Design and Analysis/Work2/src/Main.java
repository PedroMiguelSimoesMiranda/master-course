import java.util.Scanner;
/**
 * @author Pedro Miguel Simões Miranda   nº28289
 * @author Nuno  Miguel de Brito Delgado nº28455
 */
public class Main {

		public static void main(String[] args) throws InvalidElementException, NotRepresentativeException, EqualSetsException{
			Scanner sc = new Scanner(System.in);
			int P = sc.nextInt();
			int R = sc.nextInt();
			sc.nextLine();
			Graph gm = new GraphImpl(P);
			for(int i=0;i<R;i++){
				int pi=sc.nextInt()-1;
				int pj=sc.nextInt()-1;
				int wij = sc.nextInt();
				gm.addEdge(pi, pj, wij);
				sc.nextLine();
			}
			System.out.println(Kruskal.mstKruskal(gm));
		}
}
