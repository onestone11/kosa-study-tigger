import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int speedLimits[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            speedLimits[i][0] = Integer.parseInt(st.nextToken());
            speedLimits[i][1] = Integer.parseInt(st.nextToken());
        }

        int passedVehicles = 0;
        for (int i = 0; i < m; i++) {
            boolean isPassed = true;
            int speed = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                int minSpeed = speedLimits[j][0];
                int maxSpeed = speedLimits[j][1];
                if (speed < minSpeed || maxSpeed < speed) {
                    isPassed = false;
                }
            }
            if (isPassed)
                passedVehicles++;
        }

        System.out.println(passedVehicles);
    }
}
