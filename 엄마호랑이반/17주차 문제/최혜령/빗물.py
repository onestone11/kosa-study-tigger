h, w = map(int, input().split())
blocks = list(map(int, input().split()))

# 각 위치에서 왼쪽과 오른쪽의 최대 높이 계산
left_max = [0] * w
right_max = [0] * w

# 왼쪽에서 오른쪽으로 최대 높이 계산
left_max[0] = blocks[0]
for i in range(1, w):
    left_max[i] = max(left_max[i-1], blocks[i])

# 오른쪽에서 왼쪽으로 최대 높이 계산
right_max[w-1] = blocks[w-1]
for i in range(w-2, -1, -1):
    right_max[i] = max(right_max[i+1], blocks[i])

# 각 위치에서 고일 수 있는 물의 양 계산
answer = 0
for i in range(w):
    # 현재 위치에서 고일 수 있는 물의 높이는 
    # 왼쪽과 오른쪽 최대 높이 중 작은 값에서 현재 기둥 높이를 뺀 값
    water_height = min(left_max[i], right_max[i]) - blocks[i]
    
    # 음수가 아닌 경우에만 물의 양 추가
    if water_height > 0:
        answer += water_height

print(answer)
