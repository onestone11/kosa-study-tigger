import math

# a는 하루에 올라갈 수 있는 높이
# b는 미끌어지는 높이
# v는 목표 높이
a, b, v = map(int, input().split())

# v <= (a - b) * (k - 1) + a
# k = 마지막 날, k - 1 = 마지막 전 날
# 마지막 날 전까지는 a 만큼 올라가고 b 만큼 미끌어지기를 반복 => `a - b` 씩 `k - 1` 번 반복
# 그 다음 날 a 만큼 올라가면 목표(v)보다 크거나 같음
# k >= (v - a) / (a - b)) + 1, k의 최소값
print(math.ceil((v - a) / (a - b)) + 1)
