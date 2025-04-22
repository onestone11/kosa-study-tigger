import java.util.HashMap;

public class 전화번호목록 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "119", "97674223", "1195524421" }));
		System.out.println(solution(new String[] { "123", "456", "789" }));
		System.out.println(solution(new String[] { "12", "123", "1235", "567", "88" }));
	}

	private static boolean solution(String[] phone_book) {

		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<>();
		for (String number : phone_book) {
			map.put(number, 1);
		}

		Main: for (String number : phone_book) {
			for (int i = 0; i < number.length(); i++) {
				String str = number.substring(0, i);
				if (map.containsKey(str)) {
					answer = false;
					break Main;
				}
			}
		}

		return answer;
	}
}
