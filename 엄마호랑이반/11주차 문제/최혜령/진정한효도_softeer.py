import sys
# import numpy as np
ground_horizontal = [[], [], []]
min = -1
for _ in range(3):
    line = list(map(int, sys.stdin.readline().strip().split(" ")))
    tmp = 0
    small, mid, large = sorted(line)
    tmp += (abs(mid-small)+abs(large-mid))
    if min == -1 or tmp < min:
        min = tmp
    ground_horizontal[0].append(line[0])
    ground_horizontal[1].append(line[1])
    ground_horizontal[2].append(line[2])
# 세로 길이 맞추기
if min > 0:
    for h in ground_horizontal:
        tmp = 0
        small, mid, large = sorted(h)
        tmp += (abs(mid-small)+abs(large-mid))
        if min == -1 or tmp < min:
            min = tmp
print(min)
