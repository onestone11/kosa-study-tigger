import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Character> dic = new HashSet<>();
        
        for(int cnt=0; cnt<n; cnt++) {
            String[] words = br.readLine().split(" ");
            boolean flags = false;
            StringBuilder sb = new StringBuilder();

            // 1 STEP : 단어 첫 글자 확인
            for(int i=0; i<words.length; i++) {
                char temp = words[i].charAt(0);
                if(!dic.contains(Character.toUpperCase(temp))) {
                    dic.add(Character.toUpperCase(temp));
                    flags = true;
                    sb.append("[").append(temp).append("]");
                    sb.append(words[i].substring(1));
                    words[i] = sb.toString();
                    break;
                }
            }

            // 2 STEP : flags가 false일 경우 알파벳 확인
            for(int j=0; j<words.length; j++) {
                if(!flags) {
                    for(int k=0; k<words[j].length(); k++) {
                        char temp = words[j].charAt(k);
                        if(!dic.contains(Character.toUpperCase(temp))) {
                            dic.add(Character.toUpperCase(temp));
                            flags = true;
                            sb.append(words[j].substring(0, k));
                            sb.append("[").append(temp).append("]");
                            sb.append(words[j].substring(k+1, words[j].length()));
                            words[j] = sb.toString();
                            break;
                        }
                    }
                } else break;
            }
            
            sb = new StringBuilder();
            for(int m=0; m<words.length+1; m++) {
                if(m==words.length) sb.deleteCharAt(sb.length()-1);
                else {
                    sb.append(words[m]);
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
