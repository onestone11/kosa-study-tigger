import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력될 숫자의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // N개의 숫자를 저장할 배열 생성
        int[] numbers = new int[N];

        // N개의 숫자 입력 받기
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(numbers);

        // 정렬된 숫자 출력
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}