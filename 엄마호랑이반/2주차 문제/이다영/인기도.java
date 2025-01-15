package org.example.codingtest;

// Hanyang Popularity Exceeding Competition

import java.io.*;

public class ST_9495 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] tmp = br.readLine().split(" ");
			int p = Integer.parseInt(tmp[0]);
			int c = Integer.parseInt(tmp[1]);

			if (Math.abs(p - x) <= c) {
				x++;
			}
		}

		System.out.println(x);
	}
}
