import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    
    public static Queue<Integer> queue = new LinkedList<>();
    public static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;

    public static void dfs(int v) {
        // 현재 노드 방문 처리
        dfsVisited[v-1] = true;
        System.out.print(v + " ");

        if(hm.get(v) == null) return;

        ArrayList<Integer> arr = hm.get(v);
        Collections.sort(arr);
        for(int i=0; i<arr.size(); i++) {
            if(!dfsVisited[hm.get(v).get(i)-1]) dfs(hm.get(v).get(i));
        }
    }

    public static void bfs(int v) {
        // 현재 노드 방문 처리
        queue.offer(v);
        bfsVisited[v-1] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            if(hm.get(v) == null) return;
            
            ArrayList<Integer> arr = hm.get(temp);
            Collections.sort(arr);

            for(int i=0; i<arr.size(); i++) {
                if(!bfsVisited[arr.get(i)-1]) {
                    queue.offer(arr.get(i));
                    bfsVisited[arr.get(i)-1] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());       // 정점의 개수
        int m = Integer.parseInt(st.nextToken());       // 간선의 개수
        int v = Integer.parseInt(st.nextToken());       // 탐색을 시작할 정점의 번호

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!hm.containsKey(x)) hm.put(x, new ArrayList<>(Arrays.asList(y)));
            else hm.get(x).add(y);
            
            if(!hm.containsKey(y)) hm.put(y, new ArrayList<>(Arrays.asList(x)));
            else hm.get(y).add(x);
        }
        
        dfsVisited = new boolean[n];
        bfsVisited = new boolean[n];
        dfs(v);
        System.out.println();
        bfs(v);
        br.close();
    }
}

