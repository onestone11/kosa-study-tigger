import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRG_42888 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        
        for(String re : record) {
            String[] temp = re.split(" ");
            if(!temp[0].equals("Leave")) users.put(temp[1], temp[2]);
        }
        
        for(String re : record) {
            String[] temp = re.split(" ");
            if(temp[0].equals("Enter")) answer.add(users.get(temp[1]) + "님이 들어왔습니다.");
            else if(temp[0].equals("Leave")) answer.add(users.get(temp[1]) + "님이 나갔습니다.");
        }
        
        System.out.println(Arrays.toString(answer.toArray(String[]::new)));
    }
}
