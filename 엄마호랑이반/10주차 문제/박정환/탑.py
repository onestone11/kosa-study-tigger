n = int(input())
a = list(map(int,input().split()))
answer= [0] * n
stack = []

for i in range(len(a)):
    while stack:
        if a[stack[-1][0]]<a[i]:
            stack.pop()
        else:
            answer[i] = stack[-1][0]+1
            break
    stack.append((i, a[i]))
print(*answer)
