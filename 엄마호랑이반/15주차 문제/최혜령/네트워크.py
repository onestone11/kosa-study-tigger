from collections import deque

def solution(n, computers):
    visited = [False] * n
    queue = deque()
    network_count = 0

    for i in range(n):
        if not visited[i]:  # 방문하지 않은 컴퓨터라면 BFS 시작
            queue.append(i)
            while queue:
                node = queue.popleft()
                visited[node] = True
                for neighbor in range(n):
                    if computers[node][neighbor] == 1 and not visited[neighbor]:
                        queue.append(neighbor)
            network_count += 1  # BFS가 끝나면 하나의 네트워크 탐색 완료

    return network_count
