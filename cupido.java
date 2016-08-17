import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class cupido {
	public static void main(String... args) {
		Scanner scn = new Scanner(System.in);
		
		ArrayList<Integer> v = new ArrayList<>(1010);
		
		int n = scn.nextInt();
		for( int i = 0; i < n; ++i )
			v.add(scn.nextInt());
		
		Collections.sort(v);
		
		int dif1 = 0, dif2 = 0;
		for( int i = 1; i < n; i += 2 )
			dif1 += Math.min(Math.abs(v.get(i)-v.get(i-1)), 24-Math.abs(v.get(i)-v.get(i-1)));
		
		dif2 += Math.min(Math.abs(v.get(0)-v.get(n-1)), 24-Math.abs(v.get(0)-v.get(n-1)));
		for( int i = 2; i < n-1; i += 2 )
			dif2 += Math.min(Math.abs(v.get(i)-v.get(i-1)), 24-Math.abs(v.get(i)-v.get(i-1)));
		
		System.out.println(Math.min(dif1, dif2));
	}
}
