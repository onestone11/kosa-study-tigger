def solution(cap, n, deliveries, pickups):
    answer = 0  # 왕복 거리의 총합을 저장할 변수
    deliverySum = 0  # 배달할 물품의 누적량
    pickupSum = 0    # 수거할 물품의 누적량
    
    # n-1번째 집부터 0번째 집까지 반복 (뒤에서부터 처리)
    for i in range(n-1, -1, -1):
        cnt = 0  # 왕복 횟수를 세기 위한 변수
        deliverySum += deliveries[i]  # 현재 집의 배달할 물품을 누적
        pickupSum += pickups[i]       # 현재 집의 수거할 물품을 누적
        
        # 배달할 물품이나 수거할 물품이 남아 있는 동안 반복
        while deliverySum > 0 or pickupSum > 0:
            deliverySum -= cap  # 배달할 수 있는 최대 용량만큼 배달
            pickupSum -= cap    # 수거할 수 있는 최대 용량만큼 수거
            cnt += 1  # 한 번 왕복했으므로 카운트를 증가시킴
        
        # 해당 집까지의 왕복 거리를 총합에 더함
        answer += (i + 1) * 2 * cnt  # (i+1)은 해당 집까지의 거리, 2는 왕복 거리, cnt는 왕복 횟수
    
    return answer  # 최종 계산된 총 왕복 거리를 반환
