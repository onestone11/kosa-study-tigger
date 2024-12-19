char nextGreatestLetter(char *letters, int lettersSize, char target)
{
    int start = 0, end = lettersSize - 1;

    while (start <= end)
    {
        int mid = (start + end) / 2;

        // target보다 큰 문자를 찾기
        if (letters[mid] <= target)
            start = mid + 1;
        else
            end = mid - 1;
    }

    // target보다 큰 문자가 없으면 첫 번째 문자 반환
    if (start == lettersSize)
        return letters[0];

    return letters[start];
}
