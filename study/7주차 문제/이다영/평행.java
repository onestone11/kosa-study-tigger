package main.java.org.example.codingtest;

// 평행
public class Pro_120875 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}}));
    }

    public static int solution(int[][] dots) {
        if (check(dots, 0, 1) == check(dots, 2, 3)) return 1;
        else if (check(dots, 0, 2) == check(dots, 1, 3)) return 1;
        else if (check(dots, 0, 3) == check(dots, 1, 2)) return 1;
        return 0;
    }

    public static double check(int[][] dots, int i, int j) {
        int x = dots[i][0] - dots[j][0];
        int y = dots[i][1] - dots[j][1];
        return Math.tan((double) x / y);
    }
}
