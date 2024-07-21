a = input()
answer = []
cnt=0
for i in range(len(a)):
    if a[i] =='(':
        answer.append("(")
    else:
        if a[i-1] =='(':
            answer.pop()
            cnt += len(answer)
        else:
            answer.pop()
            cnt += 1
print(cnt)
