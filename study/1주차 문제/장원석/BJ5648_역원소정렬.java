package Baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ5648_역원소정렬 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] array = new long[N];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.reverse();
			String reStr = sb.toString();
			
			array[i] = Long.parseLong(reStr);
		}
		
		Arrays.sort(array);
		StringBuilder output = new StringBuilder();
		for (long l : array) {
			output.append(l).append("\n");
		}
		
		System.out.println(output.toString());

	}

}
