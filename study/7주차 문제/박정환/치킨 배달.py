from itertools import combinations

n, m = map(int, input().split())
a = list(list(map(int, input().split())) for _ in range(n))
house = []
chicken = []
res = 214700000

for i in range(n):
    for j in range(n):
        if a[i][j] == 1:
            house.append([i, j])
        elif a[i][j] == 2:
            chicken.append([i, j])

min_res = 214700000
for i in combinations(chicken, m):
    print(i)
    tmp = 0
    for j in house:
        min_chi = 214700000
        for k in range(m):
            r = abs(j[0] - i[k][0]) + abs(j[1] - i[k][1])
            if min_chi > r:
                min_chi = r
        tmp += min_chi
    if res > tmp:
        res = tmp
print(res)


