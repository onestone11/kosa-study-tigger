package fin;

import java.util.*;

public class Programmers_13846 {
    public static void main(String args[]) {
        System.out.println(Solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }

    public static int Solution(int k, int[] tangerine) {

        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int t : tangerine) {
            if (sizeMap.containsKey(t)) {
                sizeMap.put(t, sizeMap.get(t) + 1);
            } else {
                sizeMap.put(t, 1);
            }
        }

        List<Integer> box = new ArrayList<>(sizeMap.values());
        Collections.sort(box, Collections.reverseOrder());
        int cnt = 0;
        for (int x : box) {
            k -= x;
            cnt++;
            if (k <= 0) break;
        }

        return cnt;
    }
}
