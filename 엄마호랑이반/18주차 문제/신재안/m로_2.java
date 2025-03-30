import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] beverages = new int[n];
        for (int i = 0; i < n; i++) {
            beverages[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxTypes = 0;

        for (int i = 0; i < k; i++) {
            frequencyMap.put(beverages[i], frequencyMap.getOrDefault(beverages[i], 0) + 1);
        }
        maxTypes = frequencyMap.size();
        for (int i = k; i < n; i++) {
            int left = beverages[i - k];
            if (frequencyMap.get(left) == 1) {
                frequencyMap.remove(left);
            } else {
                frequencyMap.put(left, frequencyMap.get(left) - 1);
            }

            int right = beverages[i];
            frequencyMap.put(right, frequencyMap.getOrDefault(right, 0) + 1);

            maxTypes = Math.max(maxTypes, frequencyMap.size());
        }

        System.out.println(maxTypes);
    }
}
