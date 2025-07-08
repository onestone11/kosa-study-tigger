import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    a = [list(map(int, input().split())) for _ in range(N)]
    a = sorted(a)
    max_idx = 0
    answer = 1
    
    for i in range(1, len(a)):
        if a[i][1] < a[max_idx][1]:
            max_idx = i
            answer += 1
    
    print(answer)
