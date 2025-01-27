import sys

n = int(sys.stdin.readline().strip())

answer = 2
for _ in range(n):
    # 세로 늘리기
    extra = answer - 1  # 늘려야 할 개수 계산
    answer += extra


# 상태 확인
print(answer * answer)
