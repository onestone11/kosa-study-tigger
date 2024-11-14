#include <stdio.h>

void bubbleSort(int *arr, int N);

int main(void)
{
	int N;
	scanf("%d", &N); // 숫자 개수 입력

	int arr[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]); // 숫자 입력

	bubbleSort(arr, N);

	for (int i = 0; i < N; i++)
		printf("%d\n", arr[i]);

	return 0;
}

// 버블 정렬
void bubbleSort(int *arr, int N)
{
	int temp;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N - 1 - i; j++)
		{
			if (arr[j] > arr[j + 1])
			{
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}
