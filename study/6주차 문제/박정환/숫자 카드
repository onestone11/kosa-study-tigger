n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))
answer = {}
# for i in b:
#     if i in a:
#         answer.append(1)
#     else:
#         answer.append(0)
# print(''.join(answer))

for i in range(n):
    answer[a[i]] = 'T'
for i in range(m):
    if b[i] in answer:
        print(1, end=' ')
    else:
        print(0, end=' ')
