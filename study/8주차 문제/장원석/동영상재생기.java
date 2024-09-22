import java.util.StringTokenizer;

public class 동영상재생기 {

	public static void main(String[] args) {
		System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[] { "next", "prev" }));
		System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[] { "prev", "next", "next" }));
		System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[] { "next" }));
	}

	private static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

		int video_len_sec = toSec(video_len);
		int pos_sec = toSec(pos);
		int op_start_sec = toSec(op_start);
		int op_end_sec = toSec(op_end);

		for (String cmd : commands) {
			if (pos_sec >= op_start_sec && pos_sec <= op_end_sec)
				pos_sec = op_end_sec;

			if (cmd.equals("next")) {
				if (pos_sec + 10 <= video_len_sec) {
					pos_sec += 10;
				} else {
					pos_sec = video_len_sec;
				}
			} else {
				if (pos_sec - 10 >= 0) {
					pos_sec -= 10;
				} else {
					pos_sec = 0;
				}
			}
		}

		if (pos_sec >= op_start_sec && pos_sec <= op_end_sec)
			pos_sec = op_end_sec;

		return toString(pos_sec);
	}

	private static int toSec(String str) {
		StringTokenizer st = new StringTokenizer(str, ":");

		String min = st.nextToken();
		String sec = st.nextToken();

		return Integer.parseInt(min) * 60 + Integer.parseInt(sec);
	}

	private static String toString(int sec) {
		StringBuilder sb = new StringBuilder();
		if (sec / 60 == 0)
			sb.append("00");
		else if (sec / 60 < 10)
			sb.append("0").append(sec / 60);
		else
			sb.append(sec / 60);

		sb.append(":");

		if (sec % 60 == 0)
			sb.append("00");
		else if (sec % 60 < 10)
			sb.append("0").append(sec % 60);
		else
			sb.append(sec % 60);

		return sb.toString();
	}
}
