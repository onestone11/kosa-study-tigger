/*
 * 		  1초 /1분 /1시간
 * 초침  6    /360 / -
 * 분침 0.1   / 6  /360
 * 시침 1/120 /0.5 /30
 */

public class 아날로그시계 {

	public static void main(String[] args) {
		System.out.println(solution(0, 5, 30, 0, 7, 0));
		System.out.println(solution(12, 0, 0, 12, 0, 30));
		System.out.println(solution(0, 6, 1, 0, 6, 6));
		System.out.println(solution(11, 59, 30, 12, 0, 0));
		System.out.println(solution(11, 58, 59, 11, 59, 0));
		System.out.println(solution(1, 5, 5, 1, 5, 6));
		System.out.println(solution(0, 0, 0, 23, 59, 59));
	}

	private static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

		int answer = getAlarms(h2, m2, s2) - getAlarms(h1, m1, s1);

		if (s1 == 0 && m1 == 0)
			answer++;
		
		return answer;
	}

	private static int getAlarms(int h, int m, int s) {
		int alarms = 0;

		// 분침과 초침이 만난 횟수: 
		int mCount = h * (60 - 1) + m;

		// 시침과 초침이 만난 횟수:
		int hCount = h * 60 + m;

		// 시침이 한바퀴 돌아서 정오가 된 경우
		if (h >= 12)
			hCount--;

		// 현재 시점에서 초침이 시침과 분침을 지났는지 확인
		if (m * 6 + s * 0.1 <= s * 6)
			mCount++;

		if (30 * (h % 12) + 0.5 * m + s * (1 / 120) <= s * 6)
			hCount++;

		alarms = mCount + hCount;

		if (h >= 12)
			alarms--;

		return alarms;
	}
}
