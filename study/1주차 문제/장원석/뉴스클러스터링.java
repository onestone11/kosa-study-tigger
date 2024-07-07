package Programmers.LV2;

import java.util.ArrayList;
import java.util.Collections;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));

	}

	public static int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		ArrayList<String> arrayList1 = new ArrayList<>();
		ArrayList<String> arrayList2 = new ArrayList<>();

		for (int i = 0; i < ch1.length - 1; i++) {
			if ((int) ch1[i] < 65 || (int) ch1[i] > 90 || (int) ch1[i + 1] < 65 || (int) ch1[i + 1] > 90)
				continue;
			String newStr1 = String.format("%c%c", ch1[i], ch1[i + 1]);

			arrayList1.add(newStr1);
		}

		for (int i = 0; i < ch2.length - 1; i++) {
			if ((int) ch2[i] < 65 || (int) ch2[i] > 90 || (int) ch2[i + 1] < 65 || (int) ch2[i + 1] > 90)
				continue;
			String newStr2 = String.format("%c%c", ch2[i], ch2[i + 1]);

			arrayList2.add(newStr2);
		}

		Collections.sort(arrayList1);
		Collections.sort(arrayList2);

		ArrayList<String> intersection = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();

		for (String s : arrayList1) {
			if (arrayList2.remove(s)) {
				intersection.add(s);
			}
			union.add(s);
		}

		for (String s : arrayList2) {
			union.add(s);
		}

		double answer = 0;

		if (union.size() == 0) {
			answer = 1;
		} else {
			answer = (double) intersection.size() / (double) union.size();
		}

		return (int) (answer * 65536);
	}
}
