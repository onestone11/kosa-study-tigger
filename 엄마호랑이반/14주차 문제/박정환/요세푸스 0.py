n, k = map(int, input().split())

l = [i for i in range(1, n+1)]

idx = 0

answer = []
while l:
    idx += k - 1
    if idx >= len(l):
        idx %= len(l)
    answer.append(str(l.pop(idx)))

print("<", ", ".join(answer), ">", sep="")
