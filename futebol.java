import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class futebol {
	/**
	 * @param args
	 */
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);	
		
		long jogos = scn.nextLong();
		long gols = scn.nextLong();
		
		ArrayList<Integer> saldo = new ArrayList<>(100001);
		for( int i = 0; i < jogos; ++i )
			saldo.add(null);
		
		for( int i = 0; i < jogos; ++i ) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			saldo.set(i, a-b);
		}
		
		long pontos = 0;
		Collections.sort(saldo);
		
		for( long i = jogos-1; i >= 0; --i ) {
			if( saldo.get((int)i) > 0 )
				pontos += 3;
			else if( saldo.get((int)i) == 0 && gols > 0 ) {
				pontos += 3;
				gols--;
			} else if( saldo.get((int)i) < 0 && (gols-Math.abs(saldo.get((int)i)-1)) >= 0 ) {
				pontos += 3;
				gols -= Math.abs(saldo.get((int)i)-1);
			} else if( saldo.get((int)i) < 0 && (gols-Math.abs(saldo.get((int)i))) == 0 ) {
				gols -= Math.abs(saldo.get((int)i));
				pontos++;
			} else if( saldo.get((int)i) == 0 )
				pontos++;
		}
		System.out.println(pontos);
		
	}
}
