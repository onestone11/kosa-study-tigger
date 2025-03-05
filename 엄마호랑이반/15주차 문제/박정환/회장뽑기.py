n = int(input())
dis = [[100] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    dis[i][i] = 0

while True:    
    i, j = map(int, input().split())
    if i == -1 and j == -1:
        break
    # 친구 사이일 경우
    dis[i][j] = 1
    dis[j][i] = 1    

# 플로이드 와샬 알고리즘
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+ 1):
            dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j])

res = [0] * (n+1)
score = 100
for i in range(1, n+1):
    for j in range(1, n+1):
        res[i] = max(res[i], dis[i][j])
    score = min(score, res[i])
answer = []
for i in range(1, n+1):
     # 최솟값이 같을 때 후보가 되기 때문에 추가
    if res[i] == score:
        answer.append(i)
print("%d %d" %(score, len(answer)))
for i in answer:
    print(i, end =' ') 
