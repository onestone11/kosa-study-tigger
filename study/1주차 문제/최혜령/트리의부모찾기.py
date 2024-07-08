# https://www.acmicpc.net/problem/11725

import sys

from collections import deque

def solution(n):
    n = int(n)
    adj_list = [[] for _ in range(n + 1)]
    
    for _ in range(n - 1):
        a, b = sys.stdin.readline().strip().split()
        a, b = int(a), int(b)
        adj_list[a].append(b)
        adj_list[b].append(a)
    
    parent = [0] * (n + 1)
    queue = deque([1])
    parent[1] = -1
    
    while queue:
        current = queue.popleft()
        for neighbor in adj_list[current]:
            if parent[neighbor] == 0:  # If the neighbor hasn't been visited
                parent[neighbor] = current
                queue.append(neighbor)
    
    for i in range(2, n + 1):
        print(parent[i])

n = sys.stdin.readline().strip()
solution(n)
