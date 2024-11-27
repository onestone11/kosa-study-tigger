n = int(input())
arr = list(map(int, input().split(' ')))
answer = 0

for num in arr:
    for i in range(2, num + 1):
        if num % i == 0:
            if num == i:
                answer += 1
            break

print(answer)
