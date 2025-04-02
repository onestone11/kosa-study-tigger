n , m = map(int, input().split())
speed = [list(map(int, input().split())) for _ in range(n)] 
c_sp = [int(input()) for _ in range(m)]

cnt = 0
for i in c_sp:
    if all(a <= i <= b for a, b in speed):
        cnt += 1
print(cnt)
        
