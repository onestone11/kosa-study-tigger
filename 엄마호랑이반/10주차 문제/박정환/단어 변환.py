from collections import deque

def BFS(s, e, words):
    q = deque()
    q.append((s, 0))

    while q:
        now, cnt = q.popleft()

        if now == e:
            return cnt
        for word in words:
            w_cnt = 0
            for i in range(len(word)):
                if word[i] != now[i]:
                    w_cnt+=1
            if w_cnt == 1:
                q.append((word, cnt +1))

def solution(begin, target, words):
    if target not in words:
        return 0
    else:
        return BFS(begin, target, words)
