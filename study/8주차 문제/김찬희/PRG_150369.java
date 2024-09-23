class PRG_150369 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryBox = 0;
        int pickUpBox = 0;
        
        for(int i=n-1; i>=0; i--) {
            deliveryBox -= deliveries[i];
            pickUpBox -= pickups[i];
            
            while(deliveryBox < 0 || pickUpBox < 0) {
                deliveryBox += cap;
                pickUpBox += cap;
                answer += (i+1) * 2;
            }
            
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 4, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}));
        System.out.println(solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0}));
    }
}
