# n = mobitel
n = input()
answer = []
for i in range(1, len(n)):
    for j in range(i+1, len(n)):
        first = n[:i]
        second = n[i:j]
        third = n[j:]
        w = ''.join(reversed(first)) + ''.join(reversed(second)) + ''.join(reversed(third))
        # print(w)
        answer.append(w)
print(sorted(answer)[0])
