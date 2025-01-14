package temp_dev;

import java.util.*;
import java.io.*;

public class Programmers {
	public static void main(String[] args) {
		System.out.println(solution(16));
		System.out.println(solution(2554));
		System.out.println(solution(80));
		System.out.println(solution(95));
		
	}
	
	public static int solution(int storey) {
    // 수정해야함
		int cnt = 0;
		
		while (storey > 0) {
			int last = storey % 10;
			
			if (last == 5) {
				int tmp = (storey + 5) % 10;
				
			} else if (last > 5) {
				storey += 10 - last;
				cnt += 10 - last;
				
			} else {
				storey -= last;
				cnt += last;
			}
			
			storey /= 10;
		}
		
		return cnt;
	}
}
