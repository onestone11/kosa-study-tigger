package temp_dev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestClass {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {8,6,3,7,2,5,1,4}));
		
	}
	
	public static boolean[] visited;
	public static int[] box;
	public static List<Integer> answer;
	
	public static int solution(int[] cards) {
		visited = new boolean[cards.length];
		box = cards;
		answer = new ArrayList<>();
		
		for(int card : cards) {
			if(!visited[card-1]) {
				visited[card-1] = true;
				def(card-1, 1);
			}
		}
		
		answer.sort(Comparator.reverseOrder());
		
		return (answer.size() == 0) ? 0 : answer.get(0) * answer.get(1);
	}
	
	public static void def(int idx, int count) {
		int card = box[idx];
		
		if (visited[card-1]) {
			answer.add(count);
			
		} else {
			visited[card-1] = true;
			def(card-1, ++count);
		}
	}
}
