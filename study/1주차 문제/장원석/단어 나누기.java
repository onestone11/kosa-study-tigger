package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1251_단어나누기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int length = str.length();

		ArrayList<String> arrayList = new ArrayList<>();

		for (int i = 1; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				StringBuilder sb1 = new StringBuilder(str.substring(0, i));
				StringBuilder sb2 = new StringBuilder(str.substring(i, j));
				StringBuilder sb3 = new StringBuilder(str.substring(j, length));
				StringBuilder sb = new StringBuilder();

				sb1.reverse();
				sb2.reverse();
				sb3.reverse();
				sb.append(sb1.toString()).append(sb2.toString()).append(sb3.toString());
								
				arrayList.add(sb.toString());
			}
		}
		
		Collections.sort(arrayList);

		System.out.println(arrayList.get(0));
	}

}

