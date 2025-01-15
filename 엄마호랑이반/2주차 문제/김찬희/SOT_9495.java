import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 0;

        for(int i=0; i<n; i++) {
            String[] temp = br.readLine().split(" ");
            int p = Integer.parseInt(temp[0]);
            int c = Integer.parseInt(temp[1]);

            if(Math.abs(p - x) <= c) x++;
        }
        System.out.println(x);
    }
}
