# 백준 2498번 : 탑
n = int(input())
towers = list(map(int, input().split()))
answer = [0] * n
stack = []

for i in range(n):
  while stack:
    cs = stack.pop(-1)
    if towers[cs] > towers[i]:
      answer[i] = cs + 1
      stack.append(cs)
      break
  stack.append(i)
  

print(" ".join(map(str, answer)))
