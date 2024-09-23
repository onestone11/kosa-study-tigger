package main.java.org.example.codingtest;

// 동영상 재생기
public class Pro_340213 {
    private static int nowMin;
    private static int nowSec;
    private static String[] opStr;
    private static String[] opEnd;

    public static void main(String[] args) {
//        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[] {"next", "prev"}));
//        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[] {"prev", "next", "next"}));
//        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[] {"next"}));
//        System.out.println(solution("30:00", "29:55", "01:00", "01:30", new String[] {"next"}));
//        System.out.println(solution("30:00", "01:55", "01:00", "01:30", new String[] {"next"}));
//        System.out.println(solution("30:00", "00:08", "00:00", "00:05", new String[] {"prev"}));
//        System.out.println(solution("30:00", "00:11", "05:00", "06:00", new String[] {"prev"}));
//        System.out.println(solution("59:59", "59:45", "00:00", "01:05", new String[] {"next"}));
        System.out.println(solution("30:00", "01:05", "01:00", "01:30", new String[]{"prev"}));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int finMin = Integer.parseInt(video_len.split(":")[0]);
        int finSec = Integer.parseInt(video_len.split(":")[1]);
        nowMin = Integer.parseInt(pos.split(":")[0]);
        nowSec = Integer.parseInt(pos.split(":")[1]);
        opStr = op_start.split(":");
        opEnd = op_end.split(":");

        for (String command : commands) {
            // 1. 오프닝 위치 확인
            openingChk();

            // 2. command 적용
            if ("prev".equals(command)) {
                if (nowSec < 10 && nowMin >= 1) {
                    nowMin -= 1;
                    nowSec = 60 + (nowSec - 10);
                } else {
                    nowSec = Math.max(0, nowSec - 10);
                }

            } else if ("next".equals(command)) {
                if (nowSec + 10 >= 60 && nowMin < finMin) {
                    nowMin += 1;
                }

                if (nowMin == finMin) {
                    nowSec = Math.min((nowSec + 10) % 60, finSec);
                } else {
                    nowSec = (nowSec + 10) % 60;
                }
            }

            // 3. 오프닝 위치 확인
            openingChk();
        }

        String mm = nowMin < 10 ? "0" + nowMin : String.valueOf(nowMin);
        String ss = nowSec < 10 ? "0" + nowSec : String.valueOf(nowSec);

        return mm + ":" + ss;
    }

    public static void openingChk(){
        if (Integer.parseInt(opStr[0]) < nowMin ||
                (Integer.parseInt(opStr[0]) == nowMin &&
                        Integer.parseInt(opStr[1]) <= nowSec)) {
            if (nowMin < Integer.parseInt(opEnd[0]) ||
                    (nowMin == Integer.parseInt(opEnd[0]) &&
                            nowSec <= Integer.parseInt(opEnd[1]))) {

                nowMin = Integer.parseInt(opEnd[0]);
                nowSec = Integer.parseInt(opEnd[1]);
            }
        }
    }
}
