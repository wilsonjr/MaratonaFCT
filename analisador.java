import java.util.Scanner;

public class analisador {
	
	private static int lcs(String str1, String str2) 
	{
		int[][] v = new int[str1.length()+1][str2.length()+1];
		
		for( int i = 0; i < v.length; ++i )
			v[i][0] = 0;
		for( int i = 0; i < v[0].length; ++i )
			v[0][i] = 0;
		
		for( int i = 1; i < v.length; ++i )
			for( int j = 1; j < v[i].length; ++j )
				if( str1.charAt(i-1) == str2.charAt(j-1) )
					v[i][j] = v[i-1][j-1]+1;
				else
					v[i][j] = Math.max(v[i-1][j], v[i][j-1]);
		
		
		return v[v.length-1][v[0].length-1];
	}
	
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		scn.nextLine();
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		
		str1 = str1.replace(" ", "");
		str2 = str2.replace(" ", "");
		
		int n_lcs = lcs(str1, str2);
		System.out.println((n_lcs >= n ? "copia" : "nao copia"));		
	}

}
