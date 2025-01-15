import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20055 {
    public static int[] conveyor;
    public static boolean[] robots;

    // 컨베이어 벨트 회전
    public static void rotate() {
        int len = conveyor.length-1;
        int temp1 = conveyor[len];
        boolean temp2 = robots[len];

        for(int i=len; i>=1; i--) {
            conveyor[i] = conveyor[i-1];
            robots[i] = robots[i-1];
        }

        conveyor[0] = temp1;
        robots[0] = temp2;

        // 회전 후 로봇 내리는 것 확인
        down((conveyor.length/2)-1);
    }

    // 로봇 스스로 이동
    public static void move() {
        int idx = (conveyor.length / 2) - 1;

        for(int i=idx-1; i>=1; i--) {
            // 해당 칸에 로봇이 존재하고, 앞 칸에 로봇이 없으며, 가중치가 0 이상이라면 이동
            if(robots[i] && !robots[i+1] && conveyor[i+1] > 0) {
                conveyor[i+1]--;
                robots[i] = false;
                robots[i+1] = true;
            }
        }

        // 로봇 이동 후 내리는 것 확인
        down(idx);
    }

    // 로봇 내리기
    public static void down(int idx) {
        if(robots[idx]) robots[idx] = false;
    }

    // 로봇 올리기
    public static void up() {
        if(conveyor[0] > 0) {
            robots[0] = true;
            conveyor[0]--;
        }
    }

    // 0 개수 확인
    public static int check(int k) {
        int c = 0;

        for(int w : conveyor) {
            if(w == 0) c++;
        }

        return c;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);
        int answer = 0;

        conveyor = new int[2*n];
        robots = new boolean[2*n];

        String[] temp = br.readLine().split(" ");

        // conveyor belt setting
        for(int i=0; i<2*n; i++) conveyor[i] = Integer.parseInt(temp[i]);
        
        // 초기 설정 (회전 후 -> 로봇 올리기)
        rotate();
        up();
        answer++;

        while(check(k) < k) {
            rotate();
            move();
            up();
            answer++;
        }

        System.out.println(answer);
    }
}
