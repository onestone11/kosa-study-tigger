n = int(input())
queue = list(map(int, input().split()))
queue.sort()
answer = 0
tmp = 0

for time in queue:
    tmp += time
    answer += tmp

print(answer)
