import java.util.PriorityQueue;


public class Kruskal {
	
	public static PriorityQueue<Edge> buildQueue( Graph graph )
	{
		PriorityQueue<Edge> priQueue =
			new PriorityQueue<Edge>(graph.edges());
		return priQueue;
	}

	public static int mstKruskal( Graph graph ) throws InvalidElementException, NotRepresentativeException, EqualSetsException
	{
		PriorityQueue<Edge> allEdges = buildQueue(graph);
		UnionFind vertPartition =
			new UnionFindInArray( graph.getNumberNodes() );
		
		int mstFinalSize = graph.getNumberNodes() - 1;
		
		int sum=0;
		int counter=0;
		while ( counter < mstFinalSize )
		{
			Edge edge = allEdges.poll();
			int[] endPoints = edge.endVertices();
			
			int rep1 = vertPartition.find( endPoints[0] );
			int rep2 = vertPartition.find( endPoints[1] );
			
			if ( rep1 != rep2 )
			{
				vertPartition.union(rep1, rep2);
				sum+=edge.getWeight();
				counter++;
			}
		}
		return sum;
	}

}
