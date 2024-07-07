import sys
a = sys.stdin.readlines()
answer = []

for i in a:
    for j in i.split():
        answer.append(int(j[::-1]))
answer = answer[1:]
answer.sort()
print("\n".join(map(str, answer)))
