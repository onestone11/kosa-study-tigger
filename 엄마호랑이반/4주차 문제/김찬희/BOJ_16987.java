// 손에 든 계란이 깨졌거나, 깨지지 않은 다른 계란이 없으면 치지 않고 넘어감
// 종료 조건 : 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16987 {
    public static int[] eggs;
    public static int[] weights;
    public static int n;
    public static int answer = 0;

    public static void recoverEgg(int idx1, int idx2) {
        eggs[idx1] += weights[idx2];
        eggs[idx2] += weights[idx1];
    }

    public static void crackEgg(int idx, int cnt) {
        // 가장 오른쪽에 위치한 계란이라면
        if(idx == n) {
            answer = Math.max(answer, cnt);
            return;
        }

        // 손에 있는 계란이 깨져있다면 or 모든 계란이 깨져있다면
        if(eggs[idx] <= 0 || cnt == n-1) {
            crackEgg(idx+1, cnt);
            return;
        }

        int temp = cnt;
        for(int i=0; i<n; i++) {
            // 손에 든 계란과 깨드리고자하는 계란이 같은 계란이라면 or 이미 깨져있다면
            if(i == idx || eggs[i] <= 0) continue;

            // 깨지지 않은 계란이 존재하다면
            eggs[i] -= weights[idx];
            eggs[idx] -= weights[i];

            if(eggs[i] <= 0) cnt++;
            if(eggs[idx] <= 0) cnt++;

            // 다음 계란
            crackEgg(idx+1, cnt);

            // 원상복귀
            recoverEgg(i, idx);
            cnt = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new int[n];        // 내구도
        weights = new int[n];     // 무게

        for(int i=0; i<n; i++) {
            String[] temp = br.readLine().split(" ");

            eggs[i] = Integer.parseInt(temp[0]);
            weights[i] = Integer.parseInt(temp[1]);
        }
        
        crackEgg(0, 0);
        System.out.println(answer);
    }
}
