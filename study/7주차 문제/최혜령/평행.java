import java.lang.*;
class Solution {
    public int solution(int[][] dots) {
        int[] indexes = {1, 2, 3};
        for(int i = 1; i < 4; i++ ){
            double line = Math.abs((dots[0][0]-dots[i][0])/(double)(dots[0][1]-dots[i][1]));
            int i2 = 0; int i3 = 0;
            for(int j : indexes){
                if(j != i){
                    if(i2 == 0 && i3 == 0){
                        i2 = j;
                    } else if (i2 != 0 && i3 == 0){
                        i3 = j;
                    }
                }
            }
            double line2 = Math.abs((dots[i2][0] - dots[i3][0]) / (double)(dots[i2][1]-dots[i3][1]));
            
            if (line == line2) return 1;
        }
        return 0;
    }
}
