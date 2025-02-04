import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 String[] gpt = new String[n];
		 for (int i = 0; i < n; i++) {
			 st = new StringTokenizer(br.readLine());
			 gpt[i] = st.nextToken();
		 }
		 		
		 Arrays.sort(gpt, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				boolean isXDecimal = s1.contains(".");
				boolean isYDecimal = s2.contains(".");
				
				String[] x = isXDecimal ? s1.split("\\.") : new String[] { s1, "0" };
				String[] y = isYDecimal ? s2.split("\\.") : new String[] { s2, "0" };
				
				int intX = toInt(x[0]);
				int intY = toInt(y[0]);
				
				if (intX != intY) return intX - intY;
				
				if (!isXDecimal && isYDecimal) return -1;
				if (isXDecimal && !isYDecimal) return 1;
					
				return toInt(x[1]) - toInt(y[1]) ;
			}
		 });
		 
		 for (String g : gpt) {
			 System.out.println(g);
		 }
	}
	
	public static int toInt(String x) {
		return Integer.parseInt(x);
	}
}
