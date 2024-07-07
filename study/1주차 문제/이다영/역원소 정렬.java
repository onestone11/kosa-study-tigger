package fin;

import java.util.*;

// 역원소 정렬
public class BJ_5648 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		long n = Long.parseLong(st.nextToken());
		List<Long> num = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			n--;
			num.add(reverse(Long.parseLong(st.nextToken())));
		}
		
		while(sc.hasNextLine() && n > 0) {
			StringTokenizer tmp = new StringTokenizer(sc.nextLine());
			
			while(tmp.hasMoreTokens()) {
				n--;
				num.add(reverse(Long.parseLong(tmp.nextToken())));
			}
		}
		
		Collections.sort(num);
		for (long x : num ) {
			System.out.println(x);
		}
		
		sc.close();
	}
	
	
	public static long reverse(long num) {
		long result = 0;
		
		while (num > 0) {
			result *= 10;
			result += num % 10;
			num /= 10;
		}
		
		return result;
	}
}
