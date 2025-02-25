import java.util.*;
import java.io.*;

public class Main {
	private static int l;
	private static int c;
	private static String[] word;
	private static String[] code;
	private static List<String> ans;
	private static Set<String> chk;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		word = new String[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			word[i] = st.nextToken();
		}
		Arrays.sort(word);
		
		setChk();
		ans = new ArrayList<>();
		code = new String[l];
		
		findCode(0, 0);
		
		Collections.sort(ans);
		StringBuilder res = new StringBuilder();
		for(String a : ans) {
			res.append(a).append("\n");
		}
		
		System.out.print(res);
	}
	
	public static void findCode(int idx, int start)  {
		if (idx == l) {
			int vowel = 0, cons = 0;
			StringBuilder sb = new StringBuilder();
			
			for (String x : code) {
				if(chk.contains(x)) {
					vowel++;
					
				} else {
					cons++;
				}
				
				sb.append(x);
			}
			
			if (vowel >= 1 && cons >= 2) {
				ans.add(sb.toString());
			}
			
		} else {
			for (int i = start; i < c; i++) {
				code[idx] = word[i];
				findCode(idx+1, i+1);
			}
		}
	}
	
	public static void setChk() {
		chk = new HashSet<>();
		chk.add("a");
		chk.add("e");
		chk.add("i");
		chk.add("o");
		chk.add("u");
	}
}
