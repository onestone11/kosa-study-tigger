import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        sequence = new int[M];

        backtrack(0);
    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int num : sequence) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
