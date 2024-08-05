n = int(input())

d = [[0] * 100 for _ in range(100)]

for _ in range(n):
    a, b = input().rstrip().split(" ")
    a, b = int(a), int(b)
    for x in range(a, a+10):
        for y in range(b, b+10):
            if d[x][y] == 0:
                d[x][y] = 1

answer = 0

for line in d:
    for elem in line:
        if elem == 1:
            answer += 1

print(answer)
