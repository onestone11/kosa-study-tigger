import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int N, M;
    public static int[] numbers;
    public static StringBuilder sb = new StringBuilder();

    public static void back(List<Integer> values, int depth, int start) {
        if(depth == M) {
            for(int value : values) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++) {
            values.add(numbers[i]);
            back(values, depth+1, i+1);
            values.remove(values.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        numbers = new int[N];

        for(int i=0; i<N; i++) {
            numbers[i] = i+1;
        }

        back(new ArrayList<>(), 0, 0);

        System.out.println(sb);
    }
}
