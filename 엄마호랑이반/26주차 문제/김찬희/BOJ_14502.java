import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] maps;
    static int[][] maps_backup;
    static boolean[][] walls;
    static int result = 0;

    static void copyArr(int[][] arr1, int[][] arr2) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr1[j][i] = arr2[j][i];
            }
        }
    }

    static void wall_1() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[j][i] == 0 && !walls[j][i]) {
                    maps[j][i] = 1;
                    walls[j][i] = true;
                    wall_2();
                    maps[j][i] = 0;
                }
            }
        }
    }

    static void wall_2() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[j][i] == 0 && !walls[j][i]) {
                    maps[j][i] = 1;
                    walls[j][i] = true;
                    wall_3();
                    maps[j][i] = 0;
                    walls[j][i] = false;
                }
            }
        }
    }

    static void wall_3() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[j][i] == 0 && !walls[j][i]) {
                    maps[j][i] = 1;
                    walls[j][i] = true;
                    copyArr(maps_backup, maps);
                    result = Math.max(result, infect());
                    maps_backup[j][i] = 0;
                    walls[j][i] = false;
                    copyArr(maps, maps_backup);
                }
            }
        }
    }
    
    static int infect() {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] safeArea = new boolean[m][n];

        // virus(2) 위치 탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[j][i] == 2) {
                    queue.add(new Location(j, i));
                }
            }
        }

        while(!queue.isEmpty()) {
            Location location = queue.poll();
            safeArea[location.x][location.y] = true;
            
            if(maps[location.x][location.y] == 0) maps[location.x][location.y] = 2;

            for(int direction=0; direction<dx.length; direction++) {
                int x = location.x + dx[direction];
                int y = location.y + dy[direction];

                if(x >= 0 && x < m && y >= 0 && y < n && maps[x][y] == 0 && !safeArea[x][y]) queue.add(new Location(x, y));
            }
        }

        return getCount();
    }

    static int getCount() {
        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(maps[j][i] == 0) cnt++;
            }
        }

        return cnt;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 세로 크기
        m = sc.nextInt();   // 가로 크기
        maps = new int[m][n];
        maps_backup = new int[m][n];
        walls = new boolean[m][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                maps[j][i] = sc.nextInt();
            }
        }

        wall_1();

        System.out.println(result);
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
