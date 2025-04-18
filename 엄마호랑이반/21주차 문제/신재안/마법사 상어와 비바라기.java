import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int total = 0;

        int[][] basket = new int[N + 1][N + 1];
        int[][] moveCommand = new int[M][2];

        // 행 이동 정보
        int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
        // 열 이동 정보
        int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                basket[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> currCloudPosition = new ArrayList<>();
        // 시작 비구름 위치 초기화
        currCloudPosition.add(new int[] { N, 1 });
        currCloudPosition.add(new int[] { N, 2 });
        currCloudPosition.add(new int[] { N - 1, 1 });
        currCloudPosition.add(new int[] { N - 1, 2 });

        List<int[]> prevCloudPosition = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 비구름이 움직일 방향
            int direction = Integer.parseInt(st.nextToken());
            int nx = dx[direction];
            int ny = dy[direction];

            // 비구름이 움직일 거리
            int distance = Integer.parseInt(st.nextToken());

            // 비구름 이동 로직
            move(currCloudPosition, nx, ny, distance, N);

            // 비 내리기 로직
            rain(prevCloudPosition, currCloudPosition, basket);

            // 물복사 버그 로직
            waterPasteBug(currCloudPosition, basket, N);

            // 비구름 생성 로직
            generateCloud(prevCloudPosition, currCloudPosition, basket, N);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                total += basket[i][j];
            }
        }

        System.out.println(total);
    }

    private static void move(List<int[]> currCloudPosition, int dx, int dy, int s, int N) {
        List<int[]> cloudPosition = new ArrayList<>();
        for (int[] cloud : currCloudPosition) {
            int cloudX = cloud[0];
            int cloudY = cloud[1];
            cloudX += (dx * (s % N) < 0) ? dx * (s % N) + N : dx * (s % N);
            cloudY += (dy * (s % N) < 0) ? dy * (s % N) + N : dy * (s % N);

            // 경계값 처리
            cloudX %= N;
            cloudY %= N;
            if (cloudX == 0) {
                cloudX = N;
            }
            if (cloudY == 0) {
                cloudY = N;
            }

            cloudPosition.add(new int[] { cloudX, cloudY });
        }

        resetCloudPosition(currCloudPosition, cloudPosition);
    }

    private static void rain(List<int[]> prevCloudPosition, List<int[]> currCloudPosition, int[][] basket) {
        for (int[] cloud : currCloudPosition) {
            basket[cloud[0]][cloud[1]]++;
        }
        resetCloudPosition(prevCloudPosition, currCloudPosition);
    }

    private static void waterPasteBug(List<int[]> currCloudPosition, int[][] basket, int N) {
        int[] dx = { -1, -1, 1, 1 };
        int[] dy = { -1, 1, 1, -1 };

        for (int[] cloud : currCloudPosition) {
            int increase = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cloud[0] + dx[i];
                int ny = cloud[1] + dy[i];

                if (nx > N || nx < 1 || ny > N || ny < 1) {
                    continue;
                }

                if (basket[nx][ny] > 0) {
                    increase++;
                }
            }
            basket[cloud[0]][cloud[1]] += increase;
        }
    }

    private static void generateCloud(List<int[]> prevCloudPosition, List<int[]> currCloudPosition, int[][] basket,
            int N) {
        List<int[]> cloudPosition = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (basket[i][j] >= 2 && !isContainsPosition(prevCloudPosition, i, j)) {
                    basket[i][j] -= 2;
                    cloudPosition.add(new int[] { i, j });
                }
            }
        }

        resetCloudPosition(currCloudPosition, cloudPosition);
    }

    private static boolean isContainsPosition(List<int[]> cloudPosition, int x, int y) {
        for (int[] pos : cloudPosition) {
            if (pos[0] == x && pos[1] == y) {
                return true;
            }
        }

        return false;
    }

    private static void resetCloudPosition(List<int[]> prevCloudPosition, List<int[]> newCloudPosition) {
        prevCloudPosition.clear();
        prevCloudPosition.addAll(newCloudPosition);
    }
}
