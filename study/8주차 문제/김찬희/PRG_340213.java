public class PRG_340213 {
    public static int isOpening(int pos_second, int op_start_second, int op_end_second) {
        if(pos_second >= op_start_second && pos_second <= op_end_second) return op_end_second;
        else return pos_second;
    }
    
    public static int convertTime(String[] times) {
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
    public static void main(String[] args) {
        System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[]{"next", "prev"}));
        System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
        System.out.println(solution("07:22", "04:05", "00:15", "04:07", new String[]{"next"}));
    }
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_len_second = convertTime(video_len.split(":"));
        int pos_second = convertTime(pos.split(":"));
        int op_start_second = convertTime(op_start.split(":"));
        int op_end_second = convertTime(op_end.split(":"));
        
        for(int i=0; i<commands.length; i++) {
            pos_second = isOpening(pos_second, op_start_second, op_end_second);
            
            if(commands[i].equals("next")) {
                if((video_len_second - pos_second) >= 10) pos_second += 10;
                else pos_second = video_len_second;
            } else if(commands[i].equals("prev")) {
                if(pos_second < 10) pos_second = 0;
                else pos_second -= 10;
            }
            pos_second = isOpening(pos_second, op_start_second, op_end_second);
        }
        
        int minute = pos_second / 60;
        int second = pos_second % 60;
        
        answer += minute < 10 ? "0" + minute : minute;
        answer += second < 10 ? ":0" + second : ":" + second;
        
        return answer;
    }
}