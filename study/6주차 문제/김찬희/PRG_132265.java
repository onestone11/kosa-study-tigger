import java.util.HashSet;
import java.util.Set;

public class PRG_132265 {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] top1 = new int[topping.length];
        int[] top2 = new int[topping.length];
        
        top1[0] = 1;
        set1.add(topping[0]);
        
        for(int i=1; i<topping.length; i++) {
            if(!set1.contains(topping[i])) {
                set1.add(topping[i]); 
                top1[i] = top1[i-1] + 1;
            } else top1[i] = top1[i-1];
        }

        top2[topping.length-1] = 1;
        set2.add(topping[topping.length-1]);
        
        for(int j=topping.length-2; j>=0; j--) {
            if(!set2.contains(topping[j])) {
                set2.add(topping[j]);
                top2[j] = top2[j+1] + 1;
            } else top2[j] = top2[j+1];
        }

        for(int k=0; k<top1.length-1; k++) {
            if(top1[k] == top2[k+1]) answer++;
        }
        
        return answer;
    }
}
