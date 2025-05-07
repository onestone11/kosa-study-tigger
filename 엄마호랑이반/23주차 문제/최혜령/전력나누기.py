from collections import defaultdict, deque

def bfs(start, graph, visited):
    q = deque([start])
    visited[start] = True
    count = 1
    while q:
        node = q.popleft()
        for neighbor in graph[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                count += 1
                q.append(neighbor)
    return count

def solution(n, wires):
    answer = n
    
    for i in range(len(wires)):
        # 하나의 전선 제거
        temp = wires[:i] + wires[i+1:]
        
        # 그래프 만들기
        graph = defaultdict(list)
        for a, b in temp:
            graph[a].append(b)
            graph[b].append(a)
        
        visited = [False] * (n + 1)
        component_size = bfs(1, graph, visited)
        diff = abs(n - component_size - component_size)
        answer = min(answer, diff)
    
    return answer
