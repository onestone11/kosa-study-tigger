#include <stdio.h>

int main(void)
{
    int A, B, C, M;
    int tired = 0; // 현재 피로도
    int work = 0;  // 누적 작업량

    // 피로도 증가량(A), 작업량 증가량(B), 피로도 감소량(C), 최대 피로도(M)
    scanf("%d %d %d %d", &A, &B, &C, &M);

    for (int hour = 0; hour < 24; hour++)
    {
        // 현재 피로도에 A를 더해도 M 이하라면 일함
        if (tired + A <= M)
        {
            tired += A;
            work += B;
        }
        else
        {
            tired -= C;
            // 피로도가 음수가 되지 않도록 설정
            if (tired < 0)
                tired = 0;
        }
    }

    printf("%d", work);
    return 0;
}
