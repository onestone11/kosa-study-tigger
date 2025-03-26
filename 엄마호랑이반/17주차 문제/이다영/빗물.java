import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] block = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = w - 1;
        int leftMax = block[left], rightMax = block[right];
        int res = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, block[left]);
                res += Math.max(0, leftMax - block[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, block[right]);
                res += Math.max(0, rightMax - block[right]);
            }
        }

        System.out.println(res);
    } 
}
