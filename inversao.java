import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class inversao {
	
	private static int MAX = 100001;
	private static int visitado[] = new int[MAX];
	
	public static class STATE {
		private int valor, distancia, nivel;
	}
	
	public static int invertNumber(int n) {
		int k = 0;
		while( n != 0 ) {
			k *= 10;
			k += n%10;
			n /= 10;
		}
		
		return k;
	}
	
	public static int busca(int inicial, int fim) {
		for( int i = 0; i < MAX; ++i )
			visitado[i] = 0;
		Map<Integer, Integer> m = new HashMap<>();
		Queue<STATE> q = new LinkedList<>();
		
		visitado[inicial] = 1;
		m.put(inicial, inicial);
		
		STATE est = new STATE();
		est.nivel = 0;
		est.valor = inicial;
		q.add(est);
		
		STATE u = new STATE();
		while( !q.isEmpty() ) {
			u = q.peek();
			q.remove();
			
			if( u.valor == fim )
				break;
			
			STATE pp = new STATE();
			pp.valor = invertNumber(u.valor);
			pp.nivel = u.nivel+1;
			if( visitado[pp.valor] == 0 ) {
				q.add(pp);
				visitado[pp.valor] = 1;
			}
			
			pp = new STATE();
			pp.nivel = u.nivel+1;
			pp.valor = u.valor+1;
			if( visitado[pp.valor] == 0 ) {
				q.add(pp);
				visitado[pp.valor] = 1;
			}
		}
		
		return u.nivel;
	}
	
	public static void main(String...strings) {
		Scanner scn = new Scanner(System.in);
		
		int a = scn.nextInt();
		int b = scn.nextInt();
		
		System.out.println(busca(a, b));
		
	}

}
