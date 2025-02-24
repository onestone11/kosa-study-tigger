l, c = map(int, input().split())

alphabets = input().split()
alphabets.sort()
result = []

def countVowelsAndConsonants(s):
    vowelCnt = 0
    consonantCnt = 0
    for char in s:
        if char in "aeiou":
            vowelCnt += 1
        else:
            consonantCnt += 1
    return vowelCnt, consonantCnt

def checkVowelsAndConsonants(password):
    vowelCnt, consonantCnt = countVowelsAndConsonants(password)
    if vowelCnt >= 1 and consonantCnt >= 2:
        return True
    return False

def backtrack(start, password):
    if len(password) == l:
        if checkVowelsAndConsonants(password):
            result.append(password)
        return
    for i in range(start, c):
        backtrack(i + 1, password + alphabets[i])

backtrack(0, '')

for pw in result:
    print(pw)
