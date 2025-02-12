import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void binarySearch(int[] works, int time) {
        int start = 0;
        int end = works.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(works[mid] == time) {
                System.out.println(mid+1);
                return;
            }

            if(works[mid] < time) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(end+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 벌려놓은 일의 개수
        int m = Integer.parseInt(st.nextToken());   // 몇 개의 일을 처리할 수 있는지 알아볼 개수

        int[] works = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            works[i] = (i == 0) ? Integer.parseInt(st.nextToken()) : works[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<m; j++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());

            if(time < works[0]) System.out.println(0);
            else if(time >= works[n-1]) System.out.println(n);
            else binarySearch(works, time);
        }
    }
}
