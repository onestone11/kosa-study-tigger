n = int(input())

numArr = [int(input()) for _ in range(n)]

stack = []
answer = []
current = 1
possible = True

for target in numArr:
    while current <= target:
        stack.append(current)
        answer.append('+')
        current += 1

    if stack[-1] != target:
        possible = False
        break
    
    stack.pop()
    answer.append('-')

if possible:
    print('\n'.join(answer))
else:
    print("NO")
