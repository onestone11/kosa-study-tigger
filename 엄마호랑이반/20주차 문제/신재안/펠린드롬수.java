import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String num = br.readLine().strip();
            if (num.equals("0")) {
                break;
            }
            int start = 0;
            int end = num.length() - 1;
            while (true) {
                if (num.charAt(start) != num.charAt(end)) {
                    System.out.println("no");
                    break;
                }

                if (start == end || start + 1 == end) {
                    System.out.println("yes");
                    break;
                }
                start++;
                end--;
            }
        }
    }
}
