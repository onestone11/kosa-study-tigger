import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] isVisited;
    static int n, m;

    public static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        queue.add(new Node(1, 0));
        dist[1] = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(Node next : graph.get(now.v)) {
                if(dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향이니까
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra();

        System.out.println(dist[n]);
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
