package temp_dev;

import java.util.*;
import java.io.*;

public class Programmers {
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"} ));
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"} ));
		
	}
	
	public static class Info {
		String word;
		int cnt;
		
		Info(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}
	
	public static int solution(String begin, String target, String[] words) {
		if(!Arrays.asList(words).contains(target)) {
			return 0;
		}
		
		int res = Integer.MAX_VALUE;
		Deque<Info> dq = new ArrayDeque<>();
		
		for (int i = 0; i < words.length; i++) {
			if (isChange(begin, words[i])) {
				boolean[] used = new boolean[words.length];
				used[i] = true;
				dq.addLast(new Info(words[i], 1));
				
				while(!dq.isEmpty()) {
					Info info = dq.pollFirst();
					
					if (target.equals(info.word)) {
						res = Math.min(res, info.cnt);
					}
					
					for (int j = 0; j < words.length; j++) {
						if (!used[j] && isChange(info.word, words[j])) {
							used[j] = true;
							dq.addLast(new Info(words[j], info.cnt + 1));
						}
					}
				}
				
			}
		}
		
		return res > 51 ? 0 : res;
	}
	
	public static boolean isChange(String before, String after) {
		String[] bf = before.split("");
		for (String str : bf) {
			after = after.replaceFirst(str, "");
		}
		
		return after.length() == 1 ? true : false;
	}
}
