import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tang = new int[n];
        Map<Integer, Integer> hm = new HashMap<>();
        int answer = 0;
        int left = 0;

        String[] fruits = br.readLine().split(" ");
        for(int i=0; i<fruits.length; i++) {
            int fruit = Integer.parseInt(fruits[i]);
            tang[i] = fruit;
        }
    
        for(int right=0; right<n; right++) {
            hm.put(tang[right], hm.getOrDefault(tang[right], 0) + 1);

            while(hm.size() > 2) {
                if(hm.get(tang[left])-1 == 0) hm.remove(tang[left]);
                else hm.replace(tang[left], hm.get(tang[left])-1);

                left++;
            }
            answer = Math.max(answer, right-left+1);
        }
        System.out.println(answer);
    }
}
