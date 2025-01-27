import sys
n = int(sys.stdin.readline().strip())
towns = list(map(int, sys.stdin.readline().strip().split(" ")))

from itertools import combinations
all_towns = combinations(towns, 2)
distance_combs = {}
for town in all_towns:
    distance = town[1] - town[0]
    if distance not in distance_combs:
        distance_combs[distance] = 1
    else:
        distance_combs[distance] += 1
shortest = min(list(distance_combs.keys()))
print(distance_combs[shortest])
