import java.util.Scanner;

public class flowers {
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);
		String linha = scn.nextLine();
		
		char first = Character.toLowerCase(linha.charAt(0));
		
		while( first != '*' ) {
			boolean res = true;
			String[] splited = linha.split(" ");
			
			for( String s: splited ) {
				char c = Character.toLowerCase(s.charAt(0));
				res = (res && (c == first));
			}
			
			System.out.println((res ? "Y" : "N"));
			
			linha = scn.nextLine();
			first = Character.toLowerCase(linha.charAt(0));			
		}	
		
	}
}
