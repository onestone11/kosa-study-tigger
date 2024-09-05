import sys
from itertools import combinations

s = list(map(int, sys.stdin.readline().rstrip().split()))
k = s.pop(0)

result = []
result.append(s)
while k > 0:
    s = list(map(int, sys.stdin.readline().rstrip().split()))
    k = s.pop(0)
    result.append(s)

answer = []
for ls in result:
    answer.append(sorted(list(combinations(ls, 6))))
# print(len(answer))
answer_list = []
for a in answer:
    for line in a:
        elems = ""
        for elem in line:
            elems += str(elem)
            elems += " "
        elems = elems[:-1]
        answer_list.append(elems)
    answer_list.append("")

while len(answer_list[-1]) == 0 :
    answer_list.pop(-1)
for al in answer_list:
    print(al)
