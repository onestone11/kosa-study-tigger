package Programmers.LV1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 1, 3, 3, 0, 1, 1 })));
		System.out.println(Arrays.toString(solution(new int[] { 4, 4, 4, 3, 3 })));

	}

	private static int[] solution(int[] arr) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			if(queue.peekLast() != arr[i])
				queue.addLast(arr[i]);
		}
		
		int[] answer = new int[queue.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = queue.pollFirst();
		}
		
		return answer;
	}

}
