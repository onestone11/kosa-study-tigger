import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            String[] partA = a.split("\\.");
            String[] partB = b.split("\\.");

            // 소수점 앞 부분
            int x1 = Integer.parseInt(partA[0]);
            int x2 = Integer.parseInt(partB[0]);

            // 소수점 뒤 부분 처리
            int y1 = (partA.length == 1) ? -1 : Integer.parseInt(partA[1]);
            int y2 = (partB.length == 1) ? -1 : Integer.parseInt(partB[1]);

            if (x1 != x2) {
                return Integer.compare(x1, x2);
            } else {
                return Integer.compare(y1, y2);
            }
        });

        for (String num : arr) {
            System.out.println(num);
        }
    }
}
