import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            // Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 인덱스는 0부터 시작하는것 
            // i - 1 부터 j까지
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            
            // 추출한 배열 오름차순 정렬
            Arrays.sort(temp);
            
            // k번째 수를 answer에
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
