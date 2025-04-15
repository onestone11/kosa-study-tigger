import java.util.*;

class Solution {
    // 원석코장님 대리발표 부탁드립니다 고맙습니다ㅎㅎㅎㅎㅎ

  
    // [1] 데이터 입력 받음
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
    // [2] 테이블 정렬
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col-1] != o2[col-1]) {
                // col번째 컬럼의 값을 기준으로 오름차순 정렬
                return o1[col-1] - o2[col-1];
            } 
            // col번째 컬럼의 값이 동일한 경우 기본키 기준으로 내림차순 정렬
            return o2[0] - o1[0];
        });
        
        
    // [3] i번째 행의 튜플에 대해 i로 나눈 나머지들의 합
        // xor 연산은 0과 연산했을때 자기 자신이므로 0으로 초기화
        int s_xor = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int[] tmp = data[i-1];    // i번째 행 = 인덱스 i-1
            
            int s = 0;                // i번째 행의 값 / i로 나눈 나머지들의 합
            for (int t : tmp) {
                s += t % i;
            }
            
    // [4] 누적하여 xor 연산
            s_xor ^= s;
        }
        
        return s_xor;
    }
}
