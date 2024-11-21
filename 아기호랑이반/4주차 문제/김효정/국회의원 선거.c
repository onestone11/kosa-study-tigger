#include <stdio.h>

int main()
{
    int N; // 후보의 수
    scanf("%d", &N);

    int votes[50];

    for (int i = 0; i < N; i++)
        scanf("%d", &votes[i]);

    int count = 0; // 매수해야 하는 사람 수

    // 다솜이(votes[0])가 가장 많은 표를 가질 때까지 반복
    while (1)
    {
        int max = 0;
        int index = 0;

        // 최대 표를 가진 후보 찾기
        for (int i = 1; i < N; i++)
        {
            if (votes[i] > max)
            {
                max = votes[i];
                index = i;
            }
        }

        if (votes[0] > max)
            break;

        else
        {
            votes[0]++;
            votes[index]--;
            count++;
        }
    }

    printf("%d\n", count);

    return 0;
}
