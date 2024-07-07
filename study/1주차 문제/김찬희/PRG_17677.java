import java.util.ArrayList;
import java.util.List;

public class PRG_17677 {
     public static List<String> split(String str) {
        List<String> result = new ArrayList<>();
        
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) > 96 && str.charAt(i) < 123 && str.charAt(i-1) > 96 && str.charAt(i-1) < 123) result.add(str.substring(i-1, i+1));
        }
        
        return result;
    }
    
    public int solution(String str1, String str2) {
        int unionCnt = 0;
        int intersectionCnt = 0;
        double answer = 0;
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        
        arr1 = split(str1.toLowerCase());
        arr2 = split(str2.toLowerCase());
                
        // intersection
        for(int i=0; i<arr1.size(); i++) {
            if(arr2.contains(arr1.get(i))) {
                intersectionCnt++;
                arr2.set(arr2.indexOf(arr1.get(i)), " ");
            }
        }
        
        // calculate
        unionCnt = arr1.size() + arr2.size() - intersectionCnt;
        
        if(unionCnt == 0 && intersectionCnt == 0) answer = 1;
        else answer = (double)intersectionCnt / (double)unionCnt;
        
        return (int)Math.floor(answer * 65536);
    }
}
