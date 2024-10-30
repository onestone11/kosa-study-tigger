public class PRG_250137 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        int maxHealth = health;
        int attackIdx = 0;
        int continueNum = 0;
        
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            if(attacks[attackIdx][0] != i) {
                continueNum++;
                health += bandage[1];
                
                if(continueNum == bandage[0]) {
                    health += bandage[2];
                    continueNum = 0;
                }

                if(health >= maxHealth) health = maxHealth;
                else if(health < 0) break;

            } else {
                health -= attacks[attackIdx][1];
                attackIdx++;
                continueNum = 0;
            }
        }
        System.out.println(health <= 0 ? -1 : health);
    }
}
