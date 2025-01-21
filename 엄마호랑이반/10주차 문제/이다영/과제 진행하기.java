package temp_dev;

import java.util.*;
import java.io.*;

public class Programmers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString( solution(new String[][] {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
		System.out.println(Arrays.toString( solution(new String[][] {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}}) ));
		System.out.println(Arrays.toString( solution(new String[][] {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}})));
		
	}
	
	public static String[] solution(String[][] plans) {
		List<String> res = new ArrayList<>();
		Deque<String[]> last = new ArrayDeque<>();
		
		Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
		
		for (int i = 0; i < plans.length - 1; i++) {
			String[] now = plans[i];
			String[] next = plans[i+1];
			
			int nowTime = convertTime(now[1]);
			int nextTime = convertTime(next[1]);
			int workTime = Integer.parseInt(now[2]);
			
			if(nowTime + workTime <= nextTime) {
				res.add(now[0]);
				
				int subTime = nextTime - (nowTime + workTime);
				while (subTime > 0 && !last.isEmpty()) {
					String[] work = last.pollLast();
					int lastTime = Integer.parseInt(work[1]);
					
					if (lastTime > subTime) {
						lastTime -= subTime;
						last.addLast(new String[] {work[0], String.valueOf(lastTime)});
						
						break;
						
					} else {
						res.add(work[0]);
						subTime -= lastTime;
					}
				}
				
			} else {
				last.addLast(new String[] {now[0], String.valueOf(workTime - (nextTime - nowTime))});
			}
		}
		
		res.add(plans[plans.length-1][0]);
		while (!last.isEmpty()) {
			res.add(last.pollLast()[0]);
		}
		
		return res.toArray(new String[res.size()]);
	}
	
	public static int convertTime(String time) {
		String[] t = time.split(":");
		
		int hour = Integer.parseInt(t[0]);
		int minute = Integer.parseInt(t[1]);
		
		return hour * 60 + minute; 
	}
	
}
