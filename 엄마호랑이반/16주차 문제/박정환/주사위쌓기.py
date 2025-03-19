# 0 <-> 5
# 1 <-> 3
# 2 <-> 4

n = int(input())

a = [list(map(int, input().split())) for _ in range(n)]

def check(dice, b):
    for i in range(6):
        if b == dice[i]:
            break
    if i == 0: #반대편 5
        return(dice[5], max(dice[1], dice[2], dice[3], dice[4]))
    elif i == 1:# 반대편 3
        return(dice[3], max(dice[0], dice[2], dice[5], dice[4]))
    elif i == 2:# 반대편 4
        return(dice[4], max(dice[0], dice[1], dice[3], dice[5]))
    elif i == 3:# 반대편 1
        return(dice[1], max(dice[0], dice[2], dice[4], dice[5]))
    elif i == 4:# 반대편 2
        return(dice[2], max(dice[0], dice[1], dice[3], dice[5]))
    elif i == 5:# 반대편 0
        return(dice[0], max(dice[1], dice[2], dice[3], dice[4]))   
res = 0
for i in range(1, 7):
    b = i
    s_res = 0
    for j in range(n):
        b, s_tmp = check(a[j], b)
        s_res += s_tmp
    if res < s_res:
        res = s_res
print(res)
