package fin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 문자열 내 마음대로 정렬하기
public class Pro_12915 {

	public static void main(String[] args) {
		solution(new String[]{"sun", "bed", "car"}, 1);
		solution(new String[]{"abce", "abcd", "cdx"}, 2);
	}
	
	public static String[] solution(String[] strings, int n) {
		List<String> stringList = new ArrayList<>(Arrays.asList(strings));
		
		Collections.sort(stringList);
		Collections.sort(stringList, (o1, o2) -> o1.charAt(n) - o2.charAt(n));
		
        return stringList.toArray(new String[stringList.size()]);
    }
}
