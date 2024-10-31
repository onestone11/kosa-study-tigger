public class Solution {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int targetLength = number.length() - k; // 만들어야 하는 숫자의 길이

        for (int i = 0; i < number.length(); i++) {
            char currentChar = number.charAt(i);

            // result의 마지막 문자보다 currentChar가 크면 제거하면서 k 감소
            while (result.length() > 0 && result.charAt(result.length() - 1) < currentChar && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }

            result.append(currentChar);
        }


        return result.substring(0, targetLength);
    }
}
