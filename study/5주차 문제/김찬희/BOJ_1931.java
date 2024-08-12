package study.5주차 문제.김찬희;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int start = meetings[0][0];
        int end = meetings[0][1];

        for(int m=1; m<n; m++) {
            if(end <= meetings[m][0]) {
                start = meetings[m][0];
                end = meetings[m][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
