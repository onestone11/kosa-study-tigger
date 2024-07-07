package fin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 단어 나누기
public class BJ_1251 {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder word = new StringBuilder(br.readLine());
		List<String> wordList = new ArrayList<>();
		
		for (int i = 1; i < word.length()-1; i++) {
			for (int j = i+1; j < word.length(); j++) {
				StringBuilder first = new StringBuilder(word.substring(0, i)).reverse();
				StringBuilder second = new StringBuilder(word.substring(i, j)).reverse();
				StringBuilder third = new StringBuilder(word.substring(j)).reverse();
				
				
				StringBuilder fin = new StringBuilder().append(first).append(second).append(third);
				wordList.add(fin.toString());
			}
		}
		
		Collections.sort(wordList);
		System.out.println(wordList.get(0));
		
	}
}
