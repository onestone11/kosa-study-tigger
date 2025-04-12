import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static Location festival;

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public static void bfs(Location house, List<Location> storeLocations) {
        Queue<Location> queue = new LinkedList<>();
        boolean[] isVisitedStore = new boolean[storeLocations.size()];

        queue.add(house);

        while(!queue.isEmpty()) {
            Location now = queue.poll();

            // 집 -> 페스티벌이 맥주 20병으로 갈 수 있는 거리라면 happy 출력 후 종료
            if(getDistance(now.x, now.y, festival.x, festival.y) <= 1000) {
                System.out.println("happy");
                return;
            }
            
            // 바로 갈 수 있는 거리가 아니라면, 즉, 집 -> 페스티벌 거리가 1000 초과라면
            for(int i=0; i<storeLocations.size(); i++) {
                if(!isVisitedStore[i]) {
                    Location store = storeLocations.get(i);
                    if(getDistance(store.x, store.y, now.x, now.y) <= 1000) {
                        isVisitedStore[i] = true;
                        queue.offer(store);
                    }
                }
            }
        }
        System.out.println("sad");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Location house = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            List<Location> storeLocations = new ArrayList<>();
            
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                storeLocations.add(new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            
            st = new StringTokenizer(br.readLine());
            festival = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs(house, storeLocations);
        }
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
