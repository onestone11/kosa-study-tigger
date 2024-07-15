import java.io.*;
import java.util.*;

public class SOT_6282 {

    public static int[][] blocks;
    public static boolean[][] isVisited;
    public static int count;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int x, int y, int n) {
        if(x<0 || x>=n || y<0 || y>=n || isVisited[x][y] || blocks[x][y] == 0) return;
        
        isVisited[x][y] = true;
        count++;
        
        for(int k=0; k<dx.length; k++) {
            dfs(x+dx[k], y+dy[k], n);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        blocks = new int[n][n];
        isVisited = new boolean[n][n];
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String[] temp = br.readLine().split("");

            for(int j=0; j<n; j++) blocks[i][j] = Integer.parseInt(temp[j]); 
        }

        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(blocks[x][y] == 1 && !isVisited[x][y]) {
                    count = 0;
                    dfs(x, y, n);
                    answer.add(count);
                }
            }  
        }

        System.out.println(answer.size());

        Collections.sort(answer);

        for(int a : answer) System.out.println(a);
    }
}
