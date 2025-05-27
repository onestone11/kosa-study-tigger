t = int(input())

def dfs(n):
    global answer
    if n == cnt:
        answer = max(answer, int(''.join(a)))
        return
    for i in range(len(a)-1):
        for j in range(i+1, len(a)):
            a[i], a[j] = a[j], a[i]
            if (n , int(''.join(a))) not in s:
                dfs(n+1)
                s.add((n, int(''.join(a))))
            a[j], a[i] = a[i], a[j]

for t in range(1, t+1):
    a, cnt = map(int, input().split())
    a = list(str(a))
    s = set()
    answer = 0
    dfs(0)

    print(f'#{t} {answer}')
