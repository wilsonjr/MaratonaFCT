import java.util.Scanner;

public class acido {
	
	private static boolean ispossible(String vet, int i, int j) 
	{
		if( i < 0 || j >= vet.length() )
			return false;
		if( vet.charAt(i) == 'C' && vet.charAt(j) == 'F' || 
			vet.charAt(i) == 'F' && vet.charAt(j) == 'C' )
			return true;
		if( vet.charAt(i) == 'S' && vet.charAt(j) == 'B' || 
			vet.charAt(i) == 'B' && vet.charAt(j) == 'S' )
			return true;
		
		return false;	
	}
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);
		
		String str = scn.next();
		int contagem = 0;
		
		while( true ) {
			int maior = 0, k = 0, indMaior = -1;
			
			for( int i = 1; i < str.length(); ++i ) {
				int x = i-1;
				int y = i;
				k = 0;
				
				while( ispossible(str, x, y) ) {
					x--; y++; k++;
				}
				
				if( k > maior ) {
					indMaior = i;
					maior = k;
				}
			}
			if( maior != 0 ) {
				contagem += maior;
				StringBuilder temp = new StringBuilder("");
				for( int i = 0; i < str.length(); ++i )
					if( i < (indMaior-maior) || i >= (indMaior+maior) )
						temp.append(String.valueOf(str.charAt(i)));
				
				str = temp.toString();
			} else 
				break;
		}
		System.out.println(contagem);
	}

}
