n, m = map(int, input().split())
know = set(map(int, input().split()[1:]))

a = []
for _ in range(m):
    a.append(set(map(int, input().split()[1:])))

answer = 0

party = [True] * m
for _ in range(m):
    for i, num in enumerate(a):
        if num & know:
            party[i] = False
            know = know | num

for i in party:
    if i:
        answer += 1

print(answer)
