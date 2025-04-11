import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, Comparator
                    .comparingInt((int[] a) -> a[col - 1])
                    .thenComparingInt(a -> -a[0]));

        List<Integer> results = new ArrayList<>();

        for (int i = row_begin; i <= row_end; i++) {
            int a = s_i(data[i - 1], i);
            results.add(a);
        }

        answer = bitwiseXor(results);

        return answer;
    }

    private int s_i(int[] array, int index) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] % index;
        }

        return sum;
    }

    private int bitwiseXor(List<Integer> array) {
        return array.stream().reduce((a, b) -> a ^ b).orElse(0);
    }
}
