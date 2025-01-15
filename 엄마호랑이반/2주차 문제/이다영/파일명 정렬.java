package org.example.codingtest;

import java.util.*;

// 파일명 정렬
public class Programmers_17686 {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(Solution(
			// new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG", "test123456png"})));
        // System.out.println(Arrays.toString(Solution(
        //     new String[] {"img2.png", "img02.png", "img1.png"})));
        System.out.println(Arrays.toString(Solution(
            new String[] {"img2.png123", "img02.png14", "img1.png123"})));

    }

    public static String[] Solution(String[] files) {
        List<String[]> fileName = new ArrayList<>();

        for (String file : files) {
            /**
             * 정규식 표현
             *   \\D : 숫자가 아닌 문자
             *   \\d : 숫자 (0-9)
             */
            String[] parts = file.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

            String head = parts[0];
            String number = parts[1];
            StringBuilder tail = new StringBuilder();   // String 변환 시 기본 값 ""으로 처리됨

            for (int i = 2; i < parts.length; i++) {
                tail.append(parts[i]);
            }

            if (number.length() > 5) {
                number = number.substring(0, 5);
                tail.insert(0, parts[1].substring(5));
            }

            fileName.add(new String[]{head, number, tail.toString()});
        }

        fileName.sort(Comparator.comparing( (String[] a) -> a[0].toLowerCase())
            .thenComparingInt(a -> Integer.parseInt(a[1]))
            .thenComparingInt(Arrays.asList(files)::indexOf));
        // (String[] a -> Arrays.asList(files).indexOf(a[0]+a[1]+a[2])의 람다식
        // indexOf 메소드는 List에만 존재

        String[] answer = new String[files.length];
        for(int i = 0; i < fileName.size(); i++) {
            answer[i] = fileName.get(i)[0] + fileName.get(i)[1] + fileName.get(i)[2];
        }

        return answer;
    }
}
