import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 과제진행하기 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] { { "korean", "11:40", "30" },
				{ "english", "12:10", "20" }, { "math", "12:30", "40" } })));
		System.out.println(Arrays.toString(solution(new String[][] { { "science", "12:40", "50" },
				{ "music", "12:20", "40" }, { "history", "14:00", "30" }, { "computer", "12:30", "100" } })));
		System.out.println(Arrays.toString(solution(
				new String[][] { { "aaa", "12:00", "20" }, { "bbb", "12:10", "30" }, { "ccc", "12:40", "10" } })));
	}

	static class Node {
		String name;
		int time;

		public Node(String name, int time) {
			this.name = name;
			this.time = time;
		}

		@Override
		public String toString() {
			return name + " " + time;
		}
	}

	private static String[] solution(String[][] plans) {
		int l = plans.length;
		List<String> answerList = new ArrayList<>();
		Stack<Node> stack = new Stack<>();

		Arrays.sort(plans, (p1, p2) -> {
			return p1[1].compareTo(p2[1]);
		});

		for (int i = 0; i < l - 1; i++) {
			String currentName = plans[i][0];
			int currentPlayTime = Integer.parseInt(plans[i][2]);

			String[] currentTimeStr = plans[i][1].split(":");
			int currentStart = Integer.parseInt(currentTimeStr[0]) * 60 + Integer.parseInt(currentTimeStr[1]);

			String[] nextTimeStr = plans[i + 1][1].split(":");
			int nextStart = Integer.parseInt(nextTimeStr[0]) * 60 + Integer.parseInt(nextTimeStr[1]);

			// 현재 과제와 다음 과제 시작 시간의 차이
			int gap = nextStart - currentStart;

			if (gap >= currentPlayTime) {
				// 현재 과제를 완료할 수 있는 경우
				answerList.add(currentName);

				// 남은 시간동안 스택의 과제 처리
				int remainTime = gap - currentPlayTime;

				while (remainTime > 0 && !stack.isEmpty()) {
					Node node = stack.peek();

					if (remainTime >= node.time) {
						remainTime -= node.time;
						answerList.add(stack.pop().name);
					} else {
						node.time -= remainTime;
						break;
					}
				}
			} else {
				// 현재 과제를 완료할 수 없는 경우
				stack.push(new Node(currentName, currentPlayTime - gap));
			}
		}

		// 마지막 과제 처리
		answerList.add(plans[l - 1][0]);

		// 스택에 남은 과제들 처리
		while (!stack.isEmpty()) {
			answerList.add(stack.pop().name);
		}

		return answerList.toArray(new String[0]);

	}

}
