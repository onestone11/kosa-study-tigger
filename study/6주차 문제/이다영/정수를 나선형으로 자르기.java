package main.java.org.example.codingtest;

// 정수를 나선형으로 배치하기
public class Pro_181832 {
    public static void main(String[] args) {
        System.out.println(Solution(4));
    }

    public static int[][] Solution(int n) {
        int[][] answer = new int[n][n];
        char flag = 'r';
        int x = 0; int y = 0;
        for (int i = 1; i < Math.pow(n, 2) + 1; i++) {
            answer[x][y] = i;

            switch (flag) {
                case 'r' :
                    if (y+1 < n && answer[x][y+1] == 0) {
                        y++;
                    } else {
                        flag = 'd';
                        x++;
                    }
                    break;
                case 'd' :
                    if (x+1 < n && answer[x+1][y] == 0) {
                        x++;
                    } else {
                        flag = 'l';
                        y--;
                    }
                    break;
                case 'l' :
                    if (0 <= y-1 && y-1 < n && answer[x][y-1] == 0) {
                        y--;
                    } else {
                        flag = 'u';
                        x--;
                    }
                    break;
                case 'u':
                    if (0 <= x-1 && x-1 < n && answer[x-1][y] == 0) {
                        x--;
                    } else {
                        flag = 'r';
                        y++;
                    }
                    break;
            }

        }

        return answer;
    }
}
