n = input()
# 중복
answer = set()

for i in range(len(n)):
    for j in range(i + 1, len(n)+1):
        answer.add(n[i:j])
print(answer)

print(len(answer))
