from collections import deque
def solution(begin, target, words):
    if target not in words:
        return 0
    
    produced = [False for _ in range(len(words))]
    print(produced)
    
    queue = deque()
    queue.append((begin, 0))
    
    while queue:
        cw, cnt = queue.popleft()
        if cw == target:
            return cnt
        for i in range(len(words)):
            if not produced[i]:
                diff = 0
                for j in range(len(cw)):
                    if cw[j] != words[i][j]:
                        diff += 1
                if diff == 1:
                    produced[i] = True
                    queue.append((words[i], cnt+1))
            
    
    answer = 0
    return answer
