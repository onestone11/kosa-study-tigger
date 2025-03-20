import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static List<int[]> dice;
	private static int[] oppo = new int[] {5, 3, 4, 1, 2, 0};
	private static int side = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dice = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int[] tmp = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			
			dice.add(tmp);
		}
		
		for (int i = 0; i < 6; i++) {
			int[] d = dice.get(0);
			int top = d[i];
      int bottom = d[oppo[i]];
						
			int nowSide = findMaxSide(d, top, bottom);
			findSide(1, top, nowSide);
		}
		
		System.out.println(side);
	}  
	
	public static void findSide(int lev, int bot, int val) {
		if (lev == n) {
			side = Math.max(side, val);
		} else {
			int[] now = dice.get(lev);
			int botIdx = 0;
			for (int i = 0; i < 6; i++) {
				if (now[i] == bot) {
					botIdx = i;
					break;
				}
			}
			int top = now[oppo[botIdx]];
			int nowSide = findMaxSide(now, top, bot);

			findSide(lev+1, top, val+nowSide);
		}
		
	}
	
	public static int findMaxSide(int[] dice, int top, int bot) {
		int maxSide = 0;
		
		for (int i = 0; i < 6; i++) {
			if (dice[i] != top && dice[i] != bot) {
				maxSide = Math.max(maxSide, dice[i]);
			}
		}
		
		return maxSide;
	}
}
