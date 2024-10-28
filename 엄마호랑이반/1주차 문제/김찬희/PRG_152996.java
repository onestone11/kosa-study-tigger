import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class PRG_152996 {
    /**
     * @return Long type
     * @param int[] weights
     */
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};

        long answer = 0;
        Double[] ratios = {1.0, 2.0/3.0, 2.0/4.0, 3.0/4.0};
        Map<Double, Integer> hm = new HashMap<>();
        
        Arrays.sort(weights);
        
        for(int weight : weights) {
            for(double ratio : ratios) {
                double k = weight * ratio;
                if(hm.containsKey(k)) answer += hm.get(k);
            }
            hm.put((double) weight, hm.getOrDefault((double) weight, 0) + 1);
        }

        System.out.println(answer);
    }
}