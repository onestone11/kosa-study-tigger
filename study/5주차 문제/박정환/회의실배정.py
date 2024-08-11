n = int(input())

answer = []

for _ in range(n):
    a, b = map(int,input().split())
    answer.append([a,b])

answer.sort(key= lambda x: (x[1], x[0]))

cnt = 0
end_t = 0
for s, t in answer:
    if s >= end_t:
        end_t = t
        cnt += 1
print(cnt)
