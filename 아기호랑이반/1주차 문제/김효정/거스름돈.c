#include <stdio.h>

int main(void)
{

    int price, change;
    int coins[] = {500, 100, 50, 10, 5, 1};

    // 물건값(price) 입력
    scanf("%d", &price);

    // 거스름돈 총액 = 1000엔을 내고 물건값(price)을 제외한 금액
    change = 1000 - price;

    int cnt = 0;

    for (int i = 0; i < 6; i++)
    {
        int coin = coins[i];
        cnt += change / coin;
        change %= coin;
    }

    printf("%d\n", cnt);
    return 0;
}
