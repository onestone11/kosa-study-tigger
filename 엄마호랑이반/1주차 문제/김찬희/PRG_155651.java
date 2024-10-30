import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PRG_155651 {
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        int start_time = 0;
        int end_time = 0;
        List<Integer> rooms = new ArrayList<>();
        
        // 오름차순으로 정렬
        Arrays.sort(book_time, new Comparator<String[]>() {
            public int compare(String[] s1, String[] s2) {
                if(s1[0].equals(s2[0])) return s1[1].compareTo(s2[1]);
                else return s1[0].compareTo(s2[0]);
            }
        });
        
        for(int i=0; i<book_time.length; i++) {
            String[] temp_start_time = book_time[i][0].split(":");
            String[] temp_end_time = book_time[i][1].split(":");
            start_time = Integer.parseInt(temp_start_time[0]) * 60 + Integer.parseInt(temp_start_time[1]);
            end_time = Integer.parseInt(temp_end_time[0]) * 60 + Integer.parseInt(temp_end_time[1]) + 10;
            
            if(rooms.isEmpty()) {
                rooms.add(end_time);
                continue;
            }
            
            boolean isAdd = false;
            
            for(int j=0; j<rooms.size(); j++) {
                if(rooms.get(j) <= start_time) {
                    rooms.set(j, end_time);
                    isAdd = true;
                    break;
                }
            }
            if(!isAdd) rooms.add(end_time);
        }
        System.out.println(rooms.size());
    }
}
