import java.util.Arrays;

public class 삼각달팽이 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4)));
		System.out.println(Arrays.toString(solution(5)));
		System.out.println(Arrays.toString(solution(6)));

	}

	static int[] dx = { 1, 0, -1 };
	static int[] dy = { 0, 1, -1 };

	private static int[] solution(int n) {

		int count = n * (n + 1) / 2;
		int[][] map = new int[n][n];

		int x = -1, y = 0;  // 시작 위치
	    int value = 1;
	    int direction = 0;
	    
	    for(int moveLen = n; moveLen > 0; moveLen--) {
	        for(int i = 0; i < moveLen; i++) {
	            x += dx[direction];
	            y += dy[direction];
	            map[x][y] = value++;
	        }
	        
	        direction = (direction + 1) % 3;
	    }

		// 1차원 배열로 변환
		int[] answer = new int[count];
		int index = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				answer[index++] = map[i][j];
			}
		}

		return answer;
	}
}
