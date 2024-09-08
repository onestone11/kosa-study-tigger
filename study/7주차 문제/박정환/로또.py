def DFS(l, i):
    if l == 6:
        print(" ".join(map(str, res)))
        return
    else:
        for i in range(i, k):
            res.append(s[i])
            DFS(l + 1, i + 1)
            res.pop()

while True:
    n = list(map(int, input().split()))
    k = n[0]
    s = n[1:]
    if k == 0:
        break
    res = []
    DFS(0,0)
    print()
