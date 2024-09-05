import sys
def solution():
    t = int(input())  # 목표 금액
    k = int(input())  # 동전 종류 수
    coins = []
    
    for _ in range(k):
        p, n = map(int, input().split())
        coins.append((p, n))
    
    # dp[i]: i 금액을 만들 수 있는 경우의 수
    dp = [0] * (t + 1)
    dp[0] = 1  # 0원을 만드는 경우는 아무 동전도 선택하지 않는 한 가지 경우
    
    # 동전 순회
    for p, n in coins:
        # 거꾸로 계산하여 각 동전의 개수를 사용할 수 있는 범위 내에서만 더해줌
        for i in range(t, -1, -1):
            for j in range(1, n + 1):
                if i - p * j >= 0:
                    dp[i] += dp[i - p * j]
    
    print(dp[t])

solution()

