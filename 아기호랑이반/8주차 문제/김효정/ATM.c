#include <stdio.h>

// 삽입 정렬 오름차순
void insertionSort(int arr[], int n)
{
    int i, j, key;

    for (i = 1; i < n; i++)
    {
        key = arr[i];

        for (j = i - 1; j >= 0 && arr[j] > key; j--)
            arr[j + 1] = arr[j];

        arr[j + 1] = key;
    }
}

int main(void)
{
    int N; // 사람 수
    scanf("%d", &N);

    int P[N]; // 돈을 인출하는 데 걸리는 시간 배열
    for (int i = 0; i < N; i++)
        scanf("%d", &P[i]);

    // 삽입 정렬 오름차순
    insertionSort(P, N);

    int total = 0;
    int current = 0;

    for (int i = 0; i < N; i++)
    {
        current += P[i];  // 누적 대기 시간
        total += current; // 총 대기 시간
    }

    printf("%d", total);
}
