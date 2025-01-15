package org.example.codingtest;

import java.util.*;

// 오픈채팅방
public class Programmers_42888 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution(
			new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan"})));
    }

    public static String[] Solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();

        for(String rec : record) {
            String[] parts = rec.split(" ");
            if (!parts[0].equals("Leave")) {
                nickname.put(parts[1], parts[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for (String rec : record) {
            String mention = "";
            String[] parts = rec.split(" ");

            if (parts[0].equals("Enter")) {
                mention = nickname.get(parts[1]) + "님이 들어왔습니다.";
            } else if (parts[0].equals("Leave")) {
                mention = nickname.get(parts[1]) + "님이 나갔습니다.";
            }

            if (!mention.equals("")) {
                answer.add(mention);
            }
        }

        return answer.toArray(new String[0]);
    }
}
