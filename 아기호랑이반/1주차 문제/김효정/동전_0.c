#include <stdio.h>

int main(void)
{
    // n은 동전의 종류의 개수, k는 총 금액
    int n, k;
    scanf("%d %d", &n, &k);

    int coins[n];

    // 동전 단위 입력
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &coins[i]);
    }

    int cnt = 0;

    // 단위가 큰 동전부터 사용하기 위해 동전 배열을 역순으로 순회
    for (int i = n - 1; i >= 0; i--)
    {
        int coin = coins[i];
        cnt += k / coin;
        k %= coin;
    }

    printf("%d\n", cnt);
    return 0;
}
