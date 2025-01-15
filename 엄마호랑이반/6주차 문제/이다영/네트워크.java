import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 부모 노드를 기록할 배열 생성 
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {    // 부모 노드를 자기 자신으로 초기화
            parent[i] = i;
        }

        // 연결 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {  // 이어져 있는 경우 노드 합치기
                    union(parent, i, j);
                }
            }    
        }
        
        Set<Integer> res = new HashSet<>();
        for (int p : parent) {
            res.add(find(parent, p));  // 부모 노드 값을 set에 넣어 중복 제거
        }
        
        return res.size();
    }

    // 노드 합치기
    public void union(int[] parent, int i , int j) {
        i = find(parent, i);
        j = find(parent, j);

        // 작은 값을 부모 노드로 초기화
        if (i < j) {
            parent[j] = i;
        } else {
            parent[i] = j;
        }
    }

    // 부모 노드 찾기
    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            return find(parent, parent[x]);  // 다른 부모노드가 있는 경우
        }
        
        return x;
    }
}
