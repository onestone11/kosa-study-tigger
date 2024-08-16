package Programmers.LV2;

public class 문자열압축 {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}

	private static int solution(String s) {

		int answer = Integer.MAX_VALUE;
		int N = s.length();
		if (N == 1)
			return 1;

		for (int i = 1; i <= N / 2; i++) {
			StringBuilder sb = new StringBuilder();
			String preStr = "";
			int cnt = 1;

			for (int j = 0; j <= N - i; j += i) {
				String targetStr = s.substring(j, j + i);

				if (preStr.equals(targetStr)) {
					cnt++;
					continue;
				}

				if (!preStr.isEmpty()) {
					if (cnt > 1) {
						sb.append(cnt);
					}
					sb.append(preStr);
				}

				preStr = targetStr;
				cnt = 1;
			}

			// 마지막 남은 문자열 조각 처리
			if (!preStr.isEmpty()) {
				if (cnt > 1) {
					sb.append(cnt);
				}
				sb.append(preStr);
			}

			// 남은 부분 추가
			if (N % i != 0) {
				sb.append(s.substring(N - N % i, N));
			}

			answer = Math.min(answer, sb.length());

		}

		return answer;
	}

}
