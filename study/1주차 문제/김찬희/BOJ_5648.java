import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5648 {
    public static Long[] answers;

    public static String reverse(char[] numbers) {
        StringBuilder sb = new StringBuilder();

        for (int i = numbers.length - 1; i >= 0; i--)
            sb.append(numbers[i]);

        return sb.toString();
    }

    public static void descendingSort(Long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    Long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int idx = 0;
        answers = new Long[n];

        for (int i = 1; i < input.length; i++) {
            if (!input[i].equals("")) {
                answers[idx] = Long.parseLong(reverse(input[i].toCharArray()));
                idx++;
            }
        }

        while (idx < n) {
            input = br.readLine().split(" ");

            for (int i = 0; i < input.length; i++) {
                if (!input[i].equals("")) {
                    answers[idx] = Long.parseLong(reverse(input[i].toCharArray()));
                    idx++;
                }
            }
        }

        descendingSort(answers);

        for (Long answer : answers)
            System.out.println(answer.toString());
    }
}
