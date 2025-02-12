n, m = map(int, input().split())
use_money = [int(input()) for _ in range(n)]

start = min(use_money)
end = sum(use_money)

while start <= end:
    mid = (start + end)//2
    charge = mid
    cnt = 1
    for i in use_money:
        if charge - i < 0: # 잔돈 - 일일 돈의 값이 음수일 경우 돈을 뽑아야 함
            cnt += 1
            charge = mid
        charge -= i

    if cnt > m:
        start = mid + 1 # 인출하는 돈을 늘려야 함
    else:
        end = mid - 1 # 인출하는 돈을 줄여야 함

print(mid)
