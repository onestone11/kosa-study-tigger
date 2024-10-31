import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int N = 1000 - sc.nextInt();
		int count = 0;
        
		int[] coin = {500,100,50,10,5,1};
        
		for(int i = 0; i < coin.length; i++) {
			if(N % coin[i] >= 0) {
				count += N / coin[i];
				N = N % coin[i];
			}	
		}
		System.out.println(count);
	}
}
