import java.util.*;

class Solution {
   public int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;

        // sort 때문에 시간 많이걸렸네 ^^
        Arrays.sort(lost);
        Arrays.sort(reserve);

        ArrayList<Integer> reserveArr = new ArrayList<>();      // 여벌 있는 학생
//        ArrayList<Integer> resultArr = new ArrayList<>();       // 도난 당한 학생중에 체육복 빌릴 수 있는 학생
        ArrayList<Integer> lostArr = new ArrayList<>();         // 도난 당한 학생

        int borrowedStudent = 0;

        // 여벌 있는 학생
        for (int r : reserve){
            reserveArr.add(r);
        }

        // 도난 당한 학생
        for(int l : lost){
            lostArr.add(l);
        }


        // 여벌 있는 학생 중에 도난 당한 학생은 뺐음  =  reserveArr 에 여벌이 있는 학생만 남음
        for (int l : lost){
            if(reserveArr.contains(l)) {
                reserveArr.remove(Integer.valueOf(l));
                lostArr.remove(Integer.valueOf(l));
            }
        }

        // 도난 당한 학생 중에 다른 여벌있는 학생에게 빌릴 수 있으면 resultArr 에 포함시킴
        for(int i=0; i< lostArr.size() ; i++){
            for(int j=0 ; j<reserveArr.size(); j++) {
                if (reserveArr.get(j).equals(lostArr.get(i) - 1) ||
                        reserveArr.get(j).equals(lostArr.get(i) + 1)) {
//                    resultArr.add(lostArr.get(i));
                    borrowedStudent ++;
//                    reserveArr.remove(i);
                    reserveArr.remove(j);
                    break;
                }
            }
        }

        answer = n - lostArr.size() + borrowedStudent ;
        return answer;
    }
}
