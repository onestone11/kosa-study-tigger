import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 회전 초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호
        int[] sushi = new int[n];
        int[] eated = new int[d+1];

        for(int i=0; i<n; i++) sushi[i] = Integer.parseInt(br.readLine());

        // 초기화
        // 쿠폰은 아예 먹었다고 치자.
        int cnt = 1;
        eated[c] = 1;

        for(int i=0; i<k; i++) {
            if(eated[sushi[i]] == 0) cnt++;

            eated[sushi[i]]++;
        }

        int answer = cnt;

        // start: j
        // end: (start + k - 1) % n
        for(int j=1; j<n; j++) {
            int end = (j + k - 1) % n;

            if(eated[sushi[end]] == 0) cnt++;

            eated[sushi[end]]++;
            
            // start를 1 증가했으니 기존 초밥 제거
            eated[sushi[j-1]]--;
            
            if(eated[sushi[j-1]] == 0) cnt--;

            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }
}
