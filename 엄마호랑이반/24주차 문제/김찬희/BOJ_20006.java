import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Player implements Comparable<Player> {
        String name;
        int level;
        boolean check;      // 이미 방에 배정되었는지 확인하는 flag
        
        Player(String name, int level) {
            this.name = name;
            this.level = level;
        }

        @Override
        public int compareTo(Player player) {
            return name.compareTo(player.name);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());       // 플레이어 수
        int m = Integer.parseInt(st.nextToken());       // 방 정원 수
        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            players[i] = new Player(nickname, level);
        }

        for (int i=0; i<p; i++) {
            List<Player> room = new ArrayList<>();

            if (!players[i].check) {
                for(int j=i; j<p; j++) {
                    if (room.size() == m) {
                        break;
                    }
                    int tempLevel = players[j].level;
                    String tempName = players[j].name;

                    if (!players[j].check && players[i].level - 10 <= tempLevel && players[i].level + 10 >= tempLevel) {
                        players[j].check = true;
                        room.add(new Player(tempName, tempLevel));
                    }
                }

                Collections.sort(room);
                if (room.size() == m) {
                    System.out.println("Started!");
                } else {
                    System.out.println("Waiting!");
                }

                for(Player player : room) {
                    System.out.println(player.level + " " + player.name);
                }
            }
        }
    }
}
