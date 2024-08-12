import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_16937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int H = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);
        boolean[][] board = new boolean[H][W];

        int n = Integer.parseInt(br.readLine());
        List<int[]> order = new ArrayList<>();
        int area = 0;

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            int R = Integer.parseInt(st[0]);
            int C = Integer.parseInt(st[1]);

            if ((R <= H && C <= W) || (R <= W && C <= H))
                order.add(new int[] { R, C });
        }

        for (int k = 0; k < order.size(); k++) {
            for (int m = k + 1; m < order.size(); m++) {
                int temp = 0;
                int[] rect1 = order.get(k);
                int[] rect2 = order.get(m);

                if ((rect1[1] + rect2[1] <= W && (Math.max(rect1[0], rect2[0]) <= H))
                        || (rect1[1] + rect2[0] <= W && (Math.max(rect1[0], rect2[1]) <= H))
                        || (rect1[0] + rect2[1] <= W && (Math.max(rect1[1], rect2[0]) <= H))
                        || (rect1[0] + rect2[0] <= W && (Math.max(rect1[1], rect2[1]) <= H))) {
                    area = Math.max(area, (rect1[0] * rect1[1]) + (rect2[0] * rect2[1]));
                } else if ((rect1[0] + rect2[0] <= H && (Math.max(rect1[1], rect2[1]) <= W))
                        || (rect1[1] + rect2[0] <= H && (Math.max(rect1[0], rect2[1]) <= W))
                        || (rect1[0] + rect2[1] <= H && (Math.max(rect1[1], rect2[0]) <= W))
                        || (rect1[1] + rect2[1] <= H && (Math.max(rect1[0], rect2[0]) <= W))) {
                            area = Math.max(area, (rect1[0] * rect1[1]) + (rect2[0] * rect2[1]));
                }
            }
        }
        System.out.println(area);
    }
}