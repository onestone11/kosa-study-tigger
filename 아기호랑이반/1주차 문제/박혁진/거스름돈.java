import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = Integer.parseInt(sc.nextLine()); // 지불가

        int change = 1000 - price; // 거스름돈
        int coinCount = 0; // 동전 개수
        int[] coins = {500, 100, 50, 10, 5, 1}; // 동전 단위 배열

        for (int coin : coins) { 
            if (change >= coin) {
                coinCount += change / coin;
                change %= coin;
            }
        }



        System.out.println(coinCount);
    }
}
