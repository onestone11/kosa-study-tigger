import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_11725 {
    
    public static boolean[] isVisited;
    public static Map<Integer, Integer> answer = new HashMap<>();
    public static Map<Integer, List<Integer>> tuple = new HashMap<>();

    public static void search(int key, int preKey) {
        if(isVisited[key]) return;

        isVisited[key] = true;
        answer.put(key, preKey);

        List<Integer> values = tuple.get(key);

        for(int i=0; i<values.size(); i++) {
            search(values.get(i), key);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n+1];
        
        for(int i=1; i<n; i++) {
            String[] str = br.readLine().split(" ");
            int key = Integer.parseInt(str[0]);
            int value = Integer.parseInt(str[1]);

            List<Integer> values1 = tuple.getOrDefault(key, new ArrayList<>());
            List<Integer> values2 = tuple.getOrDefault(value, new ArrayList<>());
            values1.add(value);
            values2.add(key);

            tuple.put(key, values1);
            tuple.put(value, values2);
            
            isVisited[key] = false;
        }
        search(1, 0);

        for(int k=2; k<=n; k++) System.out.println(answer.get(k));
    }
}