S = input()
answer = set()

for i in range(0, len(S)):
  for j in range(i+1, len(S)+1):
    answer.add(S[i:j])

print(len(answer))
