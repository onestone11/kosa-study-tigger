import sys
import bisect

n, q = map(int, sys.stdin.readline().strip().split(" "))
inputs = sorted(map(int, sys.stdin.readline().strip().split(" ")))

for _ in range(q):
    m = int(sys.stdin.readline().strip())
    # 이진 탐색으로 위치 찾기
    index = bisect.bisect_left(inputs, m)
    
    # 값이 리스트에 없는 경우 처리
    if index >= len(inputs) or inputs[index] != m:
        print(0)
    else:
        # 중간 위치에서 계산
        if 1 <= index <= len(inputs) - 2:
            print(index * (len(inputs) - index - 1))
        else:
            print(0)
