#include <stdio.h>
#include <string.h>

void reverse(char str[]);

int main(void)
{
    char str[101];
    char str_reversed[101];

    scanf("%s", str);

    strcpy(str_reversed, str); // 문자열 복사
    reverse(str_reversed);

    // 문자열 비교
    if (strcmp(str, str_reversed) == 0)
        printf("1\n");
    else
        printf("0\n");

    return 0;
}

// 문자열 뒤집기 함수
void reverse(char str[])
{
    int len = strlen(str);
    for (int i = 0; i < len / 2; i++)
    {
        char temp = str[i];
        str[i] = str[len - 1 - i];
        str[len - 1 - i] = temp;
    }
}
