# 백준 16510 : Predictable Queue
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
works = list(map(int, input().split()))

# 누적합 계산
sum_works = [0]*(n+1)

for i in range(n):
  sum_works[i+1] = sum_works[i] + works[i]

ans = []
import bisect
for _ in range(m):
  t = int(input())
  # bisect 을 활용하여 O(log n)의 시간복잡도로 인덱스 찾기
  index = bisect.bisect_right(sum_works, t)
  ans.append(index-1)

for idx in ans:
  print(idx)
