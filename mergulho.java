import java.util.ArrayList;
import java.util.Scanner;

public class mergulho {
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int r = scn.nextInt();
		int m[] = new int[n];
		for( int i = 0; i < m.length; ++i )
			m[i] = 0;
		
		for( int i = 0; i < r; ++i ) {
			int temp = scn.nextInt();
			m[temp-1] = 1;
		}
		
		boolean f = false;
		for( int i = 0; i < n; ++i )
			if( m[i] == 0 ) {
				System.out.print((i+1)+" ");
				f = true;
			}
		if( !f )
			System.out.print("*");
		System.out.println();
			
	}
}
