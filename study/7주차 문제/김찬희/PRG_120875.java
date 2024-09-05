import java.util.*;

class PRG_120875 {
    public double getGradient(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
    
    public int solution(int[][] dots) {
        int answer = 0;
        if(getGradient(dots[0], dots[1]) == getGradient(dots[2], dots[3])) answer = 1;
        else if(getGradient(dots[0], dots[2]) == getGradient(dots[1], dots[3])) answer = 1;
        else if (getGradient(dots[0], dots[3]) == getGradient(dots[1], dots[2])) answer = 1;
        else answer = 0;
        
        return answer;
    }
}