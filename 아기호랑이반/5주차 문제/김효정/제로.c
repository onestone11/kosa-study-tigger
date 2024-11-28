#include <stdio.h>

int main(void)
{
    int K, num, top = -1;

    // 스택에 입력받을 숫자의 개수 K 입력
    scanf("%d", &K);

    // 입력받은 숫자를 저장할 스택 배열 선언 (크기: K)
    int stack[K];

    // K개의 숫자를 입력받아 처리
    for (int i = 0; i < K; i++)
    {
        scanf("%d", &num);

        // 입력이 0이면 스택에서 가장 최근 숫자를 제거
        if (num == 0)
            top--;
        // 0이 아니라면 입력된 숫자를 스택에 추가
        else
            stack[++top] = num;
    }

    // 스택에 남아 있는 숫자들을 모두 더함
    int sum = 0;
    for (int i = 0; i <= top; i++)
        sum += stack[i];

    printf("%d\n", sum);

    return 0;
}
