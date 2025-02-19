import sys
from collections import deque

N, K, T = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

A.sort()

stack = []
q = deque()

for i in range(N):
    if A[i] < T:
        stack.append(A[i])
    else:
        q.append(A[i])

for _ in range(K):
    if len(stack) == 0:
        break
    else:
        T += stack.pop()
        print(T)
        while q and T > q[0]:
            stack.append(q.popleft())
            print(stack)

print(T)
