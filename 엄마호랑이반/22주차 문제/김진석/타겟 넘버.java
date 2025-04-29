class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }

    private void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
}


public class ct_22 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        int result = sol.solution(numbers, target);
        System.out.println(result);
        /*
        * 실제 경우의 수
        * +4 +1 +2 +1 = 8 -> X
        * +4 +1 +2 -1 = 6 -> X
        * +4 +1 -2 +1 = 4 -> O
        * +4 +1 -2 -1 = 2 -> X
        * +4 -1 +2 +1 = 6 -> X
        * +4 -1 +2 -1 = 4 -> O
        * +4 -1 -2 +1 = 2 -> X
        * +4 -1 -2 -1 = 0 -> X
        * -4 +1 +2 +1 = 0 -> X
        * -4 +1 +2 -1 = -2 -> X
        * -4 +1 -2 +1 = -4 -> X
        * -4 +1 -2 -1 = -6 -> X
        * -4 -1 +2 +1 = -2 -> X
        * -4 -1 +2 -1 = -4 -> X
        * -4 -1 -2 +1 = -6 -> X
        * -4 -1 -2 -1 = -8 -> X
        * 
        * result = 2
        */
    }
}
