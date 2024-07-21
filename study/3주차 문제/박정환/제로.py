a = int(input())
answer = []
for _ in range(a):
    n = int(input())
    if  n == 0:
        answer.pop()
    else:
        answer.append(n)

print(sum(answer))
