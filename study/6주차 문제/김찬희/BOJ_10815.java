import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_10815 {
    public static List<Integer> cards = new ArrayList<>();

    public static int binarySearch(int target) {
        int start = 0;
        int end = cards.size()-1;
        int mid = (start + end) / 2;

        while(start <= end) {
            if(cards.get(mid) == target) return 1;
            else if(cards.get(mid) < target) start = mid + 1;
            else end = mid - 1;

            mid = (start + end) / 2;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input_cards = br.readLine().split(" ");

        for(int k=0; k<n; k++) cards.add(Integer.parseInt(input_cards[k]));

        // 오름차순 정렬
        Collections.sort(cards);

        int m = Integer.parseInt(br.readLine());
        String[] sang_card = br.readLine().split(" ");

        for(int i=0; i<m; i++) {
            System.out.print(binarySearch(Integer.parseInt(sang_card[i])) + " ");
        }
    }
}