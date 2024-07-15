import java.util.Arrays;

class PRG_138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] arr1 = new int[tangerine[tangerine.length-1]+1];
        int[] arr2 = new int[tangerine[tangerine.length-1]+1];
        int idx = 0;
               
        // 각 종류의 개수 집어넣기
        for(int i=0; i<tangerine.length; i++) arr1[tangerine[i]] += 1;
        Arrays.sort(arr1);
        
        for(int i=arr1.length-1, j=0; i>=0; i--, j++) arr2[j] = arr1[i];
           
        while(k > 0) {
            if(k - arr2[idx] < 0) k = 0;
            else {
                k -= arr2[idx];
                idx++;
            }
            answer++;
        }
        
        return answer;
    }
}