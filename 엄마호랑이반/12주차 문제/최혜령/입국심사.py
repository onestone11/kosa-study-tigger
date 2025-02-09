def solution(n, times):
    answer = 0
    times = sorted(times.copy())
    # 범위 설정 left = 최소 분 right = 최대 분
    left, right = 1, max(times) * n
    
    while left <= right:
        # 중간값 설정
        mid = (left + right) // 2
        
        # 중간값 기준 심사 완료 인원 수 구하기
        finished = 0
        for time in times:
            if finished <= n:
                finished += mid // time
            else:
                break
                
        if finished >= n:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
    return answer
