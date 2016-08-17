import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class memoria {
	
	public static int carta, maxAltura;
	
	public static class VERTEX {
		private int u, p, gp;
		private boolean visited;
		private List<Integer> adj;
		private List<Integer> pos;
		
		public VERTEX() {
			adj = new ArrayList<>();
			pos = new ArrayList<>();
		}
	}
	
	public static void gran_p(VERTEX[] grafo, int u, int p, int seg) {
		grafo[u].gp = p;
		if( (grafo[u].u % seg) == 0 )
			p = u;
		
		for( int i = 0; i < grafo[u].adj.size(); ++i )
			if( grafo[grafo[u].adj.get(i)].gp == 0 )
				gran_p(grafo, grafo[u].adj.get(i), p, seg);
	}
	
	public static void dfs(VERTEX[] grafo, int i) {
		grafo[i].visited = true;
		
		for( int j = 0; j < grafo[i].adj.size(); ++j )
			if( !grafo[grafo[i].adj.get(j)].visited ) {
				grafo[grafo[i].adj.get(j)].u = grafo[i].u+1;
				maxAltura = Math.max(maxAltura, grafo[grafo[i].adj.get(j)].u);
				grafo[grafo[i].adj.get(j)].p = i;
				dfs(grafo, grafo[i].adj.get(j));
			}
	}
	
	public static void visita(VERTEX[] grafo, int inicial) {
		for( int i = 0; i < grafo.length; ++i ) {
			grafo[i].gp = grafo[i].u = grafo[i].p = 0;
			grafo[i].visited = false;
		}
		
		grafo[inicial].p = inicial;
		dfs(grafo, inicial);
	}
	
	public static int LCA(VERTEX[] grafo, int u, int v) {
		while( grafo[u].gp != grafo[v].gp )
			if( grafo[u].u > grafo[v].u )
				u = grafo[u].gp;
			else
				v = grafo[v].gp;
		
		while( u != v )
			if( grafo[u].u > grafo[v].u )
				u = grafo[u].p;
			else
				v = grafo[v].p;
		return u;
	}
	
	
	public static void main(String...strings)
	{
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		VERTEX[] grafo = new VERTEX[n+1];
		for( int i = 0; i < grafo.length; ++i )
			grafo[i] = new VERTEX();
		
		for( int i = 1; i <= n; ++i ) {
			int carta = scn.nextInt();
			grafo[carta].pos.add(i);
		}
		
		for( int i = 1; i < n; ++i ) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			grafo[u].adj.add(v);
			grafo[v].adj.add(u);
		}
		
		maxAltura = 0;
		visita(grafo, 1);
		int seg = (int) Math.sqrt(maxAltura);
		int q = 0;
		gran_p(grafo, 1, 1, seg);
		
		for( int i = 1; i <= n/2; ++i ) {
			int u = grafo[i].pos.get(0);
			int v = grafo[i].pos.get(1);
			int vlca = LCA(grafo, u, v);
			q += (grafo[u].u-grafo[vlca].u) + (grafo[v].u-grafo[vlca].u);
		}
		
		System.out.println(q);
			
	}
	
	
}
