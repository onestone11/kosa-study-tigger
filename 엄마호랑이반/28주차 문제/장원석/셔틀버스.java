import java.util.PriorityQueue;

public class 셔틀버스 {

	public static void main(String[] args) {
		System.out.println(solution(1, 1, 5, new String[] { "08:00", "08:01", "08:02", "08:03" }));
		System.out.println(solution(2, 10, 2, new String[] { "09:10", "09:09", "08:00" }));
		System.out.println(solution(2, 1, 1, new String[] { "09:00", "09:00", "09:00", "09:00" }));
		System.out.println(solution(1, 1, 5, new String[] { "00:01", "00:01", "00:01", "00:01", "00:01" }));
		System.out.println(solution(1, 1, 1, new String[] { "23:59" }));
		System.out.println(solution(10, 60, 45, new String[] { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" }));
	}

	// n = 셔틀버스 운행 횟수
	// t = 버스 운행 간격(분단위)
	// m = 버스 최대 승객 수
	private static String solution(int n, int t, int m, String[] timetable) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (String tt : timetable) {
			String[] times = tt.split(":");
			pq.add(Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
		}

		int start = 9 * 60; // 시작 시간
		int last = 0; // 마지막 시간
		int total = 0; // 버스 탑승 인원

		for (int i = 0; i < n; i++) {
			total = 0;

			while (!pq.isEmpty()) {
				int now = pq.peek();

				// 버스 시간보다 이전에 도착했고,
				// 마지막에 셔틀 버스에 탄 인원이 m보다 작다면, 셔틀 버스에 탈 수 있음
				if (now <= start && total < m) {
					pq.poll();
					total++;
				} else {
					break;
				}

				// 마지막 시간을 현재 크루의 시간 -1로 재설정
				last = now - 1;
			}

			start += t;
		}

		// 마지막 버스에 탄 인원이 m보다 작다면, 해당 셔틀 버스에 콘이 탈 수 있음
		if (total < m) {
			last = start - t;
		}

		// 시간 정보 시간:분 형태로 출력하기
		String hh = String.format("%02d", last / 60);
		String mm = String.format("%02d", last % 60);

		return hh + ":" + mm;
	}

}
