# 백준 2467번 : 용액
import sys
input = sys.stdin.readline
n = int(input())
ls = []

usr = list(map(int, input().split()))
# ls = sorted(usr)


left, right = 0, n-1

tmp = abs(usr[left]+usr[right])

while left < right:
  current = usr[left] + usr[right]
  if abs(current) <= tmp:
    x, y = usr[left], usr[right]
    tmp = abs(current)
    if tmp == 0:
      break
  if current < 0:
    left += 1

  else:
    right -= 1

print(f"{x} {y}")
