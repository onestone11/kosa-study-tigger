import sys
from itertools import combinations
n, m = map(int, sys.stdin.readline().rstrip().split())
chickens = []
homes = []
street = []
for i in range(n):
    line = sys.stdin.readline().rstrip().split()
    for j in range(len(line)):
        if line[j] == '1':
            homes.append((i,j))
        elif line[j] == '2':
            chickens.append((i,j))
        else:
            street.append((i,j))

if len(chickens) <= m:
    total = 0
    for home in homes:
        hi, hj = home
        shortest = float("inf")
        for chicken in chickens:
            ci, cj = chicken
            if abs(hi-ci) + abs(hj-cj) < shortest:
                shortest = abs(hi-ci) + abs(hj-cj)
        total += shortest
    print(total)
else:
    possibles = combinations(chickens, m)
    
    best = float("inf")
    best_chickent = (0,0)
    for p in possibles:
        total = 0
        for home in homes:
            hi, hj = home
            shortest = float("inf")
            for chicken in p:
                ci, cj = chicken
                if abs(hi-ci) + abs(hj-cj) < shortest:
                    shortest = abs(hi-ci) + abs(hj-cj)
                    
                    best_chickent = (ci, cj)
            total += shortest
        # print("total, ", total)
        if total < best:
            best = total
            # print("best ", best)
    print(best)
    # print(best_chickent)
        
