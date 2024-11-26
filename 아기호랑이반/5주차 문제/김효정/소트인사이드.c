#include <stdio.h>
#include <string.h>

int main(void)
{
	char num[11];
	scanf("%s", num);

	int len = strlen(num);

	for (int i = 0; i < len - 1; i++)
	{
		int max = i;

		for (int j = i + 1; j < len; j++)
		{
			if (num[max] < num[j])
			{
				char temp = num[max];
				num[max] = num[j];
				num[j] = temp;
			}
		}
	}
	printf("%s", num);

	return 0;
}
