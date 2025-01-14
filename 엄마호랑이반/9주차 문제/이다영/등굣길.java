package temp_dev;

import java.util.*;
import java.io.*;

public class Programmers_2 {
	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] {{2,2}}));
		
	}
	
	private static int endX;
	private static int endY;
	private static int[] dx = new int[] {1, 0};
	private static int[] dy = new int[] {0, 1};
	
	private static int[][] board;
	private static boolean[][] visited;
	private static TreeMap<Integer, Integer> res = new TreeMap<>(); 
	
	public static int solution(int m, int n, int[][] puddles) {
    // 수정해야됨 
		endX = m; endY = n;
		board = new int[m][n];
		
		for (int[] puddle : puddles) {
			int x = puddle[0];
			int y = puddle[1];
			
			board[x][y] = 1;
		}
		
		visited[0][0] = true;
		dfs(0, 0, 0);
		
		return res.firstEntry().getValue();
	}
	
	public static void dfs(int x, int y, int cnt) {
		if (endX - 1 == x && endY - 1 == y) {
			if (res.containsKey(cnt)) {
				res.put(cnt, res.get(cnt) + 1);
				
			} else {
				res.put(cnt, 1);
			}
		} else {
			for (int z = 0; z < 2; z++) {
				int xx = x + dx[z];
				int yy = y + dy[z];
				
				if (0 <= xx && xx < endX && 0 <= yy && yy < endX &&
					!visited[xx][yy] && board[xx][yy] == 0) {
					visited[xx][yy] = true;
					dfs(xx, yy, ++cnt);
					visited[xx][yy] = false;
				}
			}
			
			
		}
	}
}
