import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ferrovias {
	
	public static class EDGE implements Comparable<EDGE> {
		private long from, to, weight;
		
		public EDGE(long from, long to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(EDGE o) {
			return weight < o.weight ? -1 : (weight > o.weight ? 1 : 0);
		}			
	}
	
	public static class Kruskal {
	
		private static Map<Long, Long> PARENT;
		private static Map<Long, Long> RANKS;
		
		public static void inititalize(long[] universe) {
			PARENT = new HashMap<>();
			RANKS = new HashMap<>();
			for( long x: universe ) {
				PARENT.put(x, x);
				RANKS.put(x, 1l);
			}
		}
		
		public static long findSet(long item) {
			long parent = PARENT.get(item);
			return (parent == item) ? item : findSet(parent);
		}
		
		public static void union(long setA, long setB) {
			long pA, pB;
			while( (pA = PARENT.get(setA)) != setA )
				setA = pA;
			while( (pB = PARENT.get(setB)) != setB )
				setB = pB;
			
			long rankFirst = RANKS.get(setA), rankSecond = RANKS.get(setB);
			if(rankFirst>rankSecond){
                PARENT.put(setB, setA);  
                updateRanksUpward(setB);
            }else if(rankSecond>rankFirst){
                PARENT.put(setA, setB);  
                updateRanksUpward(setA);
            }else{
                PARENT.put(setB, setA); 
                updateRanksUpward(setB);
            }
		}
		
		public static void updateRanksUpward(long current) {
			long currentDepth = RANKS.get(current);
			long currentsParent = PARENT.get(current);
			long parentsDepth = RANKS.get(currentsParent);
			
			if( !(currentDepth < parentsDepth || currentsParent == current) ) {
				RANKS.put(currentsParent, currentDepth+1);
				updateRanksUpward(currentsParent);
			}
		}
		
		public static ArrayList<EDGE> kruskal(long[] vertices, EDGE[] edges) {
			ArrayList<EDGE> mst = new ArrayList<>();
			
			inititalize(vertices);
			Arrays.sort(edges);
			for( EDGE edge: edges ) {				
				if( findSet(edge.from) != findSet(edge.to) ) {
					mst.add(edge);
					union(edge.from, edge.to);
				}
			}
			
			return mst;
		}
	}
	
	public static void main(String...strings) {
		Scanner scn = new Scanner(System.in);
		
		long m = scn.nextLong();
		long n = scn.nextLong();
		
		long vertices[] = new long[(int) m];
		for( int i = 0; i < m; ++i )
			vertices[i] = i;
		EDGE edges[] = new EDGE[(int) n*2];
		
		long total = 0;
		for( int i = 0; i < 2*n; i += 2 ) {
			long a = scn.nextLong();
			long b = scn.nextLong();
			long c = scn.nextLong();
			edges[(int)i] = new EDGE(a, b, c);
			edges[(int)i+1] = new EDGE(b, a, c);
			total += c;
		}
			
		ArrayList<EDGE> mst = Kruskal.kruskal(vertices, edges);
		long soma = 0;
		for( EDGE e: mst)
			soma += e.weight;
		
		System.out.println(total-soma);
		
	}

}
