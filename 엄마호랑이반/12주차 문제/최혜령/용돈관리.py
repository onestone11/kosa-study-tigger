# 백준 6236번: 용돈 관리
import sys
input = sys.stdin.readline
n, m = map(int, input().split())

money = []
answer = 0
for _ in range(n):
  amount = int(input())
  money.append(amount)

left, right = max(money), sum(money)
while left <= right:
  mid = (left + right) // 2
  current = mid
  cnt = 1  # 첫 번째 인출은 무조건 필요하므로 1부터 시작
    
  # 현재 금액으로 지출이 가능한지 확인
  for a in money:
      if current < a:
          current = mid  # 새로 인출
          cnt += 1
      current -= a
        
  if cnt > m:  # 인출 횟수가 목표보다 많으면
      left = mid + 1
  else:  # 인출 횟수가 목표보다 적거나 같으면
      right = mid - 1
      answer = mid
print(answer)
