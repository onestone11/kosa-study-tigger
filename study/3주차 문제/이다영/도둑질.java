package main.java.org.example.codingtest;

// 도둑질
public class Programmers_42897 {
    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 3, 2, 7, 5, 3, 8}));
        System.out.println(solution(new int[]{1, 2, 3, 1}));
        System.out.println(solution(new int[]{10, 5, 3, 1, 10}));
        System.out.println(solution(new int[]{1,2,3,1}));
        System.out.println(solution(new int[]{1,1,4,1,4}));
        System.out.println(solution(new int[]{1000,0,0,1000,0,0,1000,0,0,1000}));
        System.out.println(solution(new int[]{1000,1,0,1,2,1000,0}));   // 해당 -> 2001
        System.out.println(solution(new int[]{1000,0,0,0,0,1000,0,0,0,0,0,1000}));
        System.out.println(solution(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println(solution(new int[]{0,0,0,0,100,0,0,100,0,0,1,1}));
        System.out.println(solution(new int[]{11,0,2,5,100,100,85,1}));
        System.out.println(solution(new int[]{1,2,3}));
        System.out.println(solution(new int[]{91,90,5,7,5,7}));
        System.out.println(solution(new int[]{90,0,0,95,1,1})); // 해당 -> 185

    }

    public static int solution(int[] money) {
        int n = money.length;

        int[] dpO = new int[n];
        dpO[0] = money[0];
        dpO[1] = money[1];
        dpO[2] = money[0] + money[2];

        int[] dpX = new int[n];
        dpX[0] = 0;
        dpX[1] = money[1];
        dpX[2] = money[2];

        for (int i = 3; i < n; i++) {
            dpO[i] = Math.max( dpO[i-1], dpO[i-2]+money[i] );
            dpO[i] = Math.max( dpO[i], dpO[i-3]+money[i] );

            dpX[i] = Math.max( dpX[i-1], dpX[i-2]+money[i] );
            dpX[i] = Math.max( dpX[i], dpX[i-3]+money[i] );
        }

        return Math.max( dpO[n-2], dpX[n-1] );
    }
}
