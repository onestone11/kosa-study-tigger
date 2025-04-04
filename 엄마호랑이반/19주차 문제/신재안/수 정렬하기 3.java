import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    private static int MAX_NUMBER = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] given = new int[N];

        for (int i = 0; i < N; i++) {
            given[i] = Integer.parseInt(br.readLine());
        }

        countingSort(given);
    }

    private static void countingSort(int[] list) throws IOException {
        int[] countArray = new int[MAX_NUMBER + 1];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            countArray[list[i]]++;
        }

        for (int i = 0; i <= MAX_NUMBER; i++) {
            if (countArray[i] > 0) {
                for (int j = 0; j < countArray[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
