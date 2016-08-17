import java.util.Scanner;

public class zerinho {
	
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);
		
		int a = scn.nextInt();
		int b = scn.nextInt();
		int c = scn.nextInt();
		
		if( a == b && a == c )
			System.out.println("*");
		else {
			if( a == c )
				System.out.println("B");
			else if( a == b )
				System.out.println("C");
			else 
				System.out.println("A");
		}
		
	}

}
