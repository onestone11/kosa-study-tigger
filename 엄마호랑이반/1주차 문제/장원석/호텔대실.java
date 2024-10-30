package Programmers.LV2;

public class 호텔대실 {

	public static void main(String[] args) {
		System.out.println(solution(new String[][] { { "15:00", "17:00" }, { "16:40", "18:20" }, { "14:20", "15:20" },
				{ "14:10", "19:20" }, { "18:20", "21:20" } }));
		System.out.println(solution(new String[][] { { "09:10", "10:10" }, { "10:20", "12:20" } }));
		System.out.println(solution(new String[][] { { "10:20", "12:30" }, { "10:20", "12:30" }, { "10:20", "12:30" } }

		));
	}

	private static int solution(String[][] book_time) {
		int answer = 0;
		
		int[] room = new int[1440];

		for (String[] strings : book_time) {
			int start = getMinutes(strings[0]);
			int end = getMinutes(strings[1]) + 10;
			
			for (int i = start; i < end && i < 1440; i++) {
				room[i]++;
			}
		}
		
		for (int i : room) {
			answer = Math.max(answer, i);
		}

		return answer;
	}
	
	private static int getMinutes(String str) {
		String[] splits = str.split(":");
		int hour = Integer.parseInt(splits[0]) * 60;
		int minute = Integer.parseInt(splits[1]);
		return hour + minute;
	}
}
