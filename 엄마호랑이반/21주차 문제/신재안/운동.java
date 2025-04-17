import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 목표 운동 시간
        int N = Integer.parseInt(st.nextToken());
        // 시작 맥박 및 최저 맥박
        int m = Integer.parseInt(st.nextToken());
        // 최대 맥박
        int M = Integer.parseInt(st.nextToken());
        // 1분 운동 시 상승 맥박
        int T = Integer.parseInt(st.nextToken());
        // 1분 휴식 시 하강 맥박
        int R = Integer.parseInt(st.nextToken());

        // 총 시간의 흐름을 카운팅
        int timer = 0;
        // 총 운동 시간을 카운팅
        int workoutTime = 0;
        // 현재 맥박 정보를 저장
        int currentPulse = m;

        // 운동을 한 번도 할 수 없는 경우
        if(m + T > M) {
            System.out.println(-1);
            return;
        }

        while(workoutTime < N) {
            if(currentPulse + T > M) {
                currentPulse -= R;
                if(currentPulse < m) {
                    currentPulse = m;
                }
            } else {
                currentPulse += T;
                workoutTime++;
            }
            timer++;
        }
        System.out.println(timer);
        return;
    }
}
