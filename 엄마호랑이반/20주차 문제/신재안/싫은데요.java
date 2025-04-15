import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] holes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int start = 0;
        int sum = 0;
        int max = 0;

        for (int end = 0; end < n; end++) {
            sum += holes[end];

            while (sum > m) {
                sum -= holes[start];
                start++;
            }

            if (max < sum) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
