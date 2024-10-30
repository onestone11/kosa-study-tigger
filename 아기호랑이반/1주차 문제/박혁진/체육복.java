import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 잃어버린 사람 배열을 list로 전환
        List<Integer> lostList = new ArrayList<>();
        for (int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }

        // 빌려줄 수 있는 사람 배열을 list로 전환
        List<Integer> reserveList = new ArrayList<>();
        for (int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }


        
        // // 중복 제거: 여벌이 있는 학생이 체육복을 잃어버린 경우 lostList와 reserveList에서 제거
        for(int number : lost){
            if(reserveList.contains(number)){
               reserveList.remove(Integer.valueOf(number));
               lostList.remove(Integer.valueOf(number));
            }
        }
        
        Collections.sort(reserveList);
        Collections.sort(lostList);

    
        // 현재 체육복을 가진 학생 수 초기화
        int currentCount = n - lostList.size();

        
        // 남은 reserveList에서 잃어버린 학생에게 체육복 빌려주기
        for (int number : reserveList) {
            if (lostList.contains(number - 1)) { // 앞 번호가 잃어버린 학생이라면
                lostList.remove(Integer.valueOf(number - 1));
                currentCount++;
            } else if (lostList.contains(number + 1)) { // 뒷 번호가 잃어버린 학생이라면
                lostList.remove(Integer.valueOf(number + 1));
                currentCount++;
            }
        }

        return currentCount;
    }
}
