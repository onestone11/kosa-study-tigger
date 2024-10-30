import heapq
def solution(scores):
    wonho = scores[0]
    
    
    for score in scores:
        if wonho[0] < score[0] and wonho[1] < score[1]:
            return -1
    
    # 첫 번째 점수 기준 내림차순, 두 번째 점수 기준 오름차순 정렬
    scores.sort(key=lambda x: (-x[0], x[1]))
    
    
    qualified = []
    max_second = 0  # 두 번째 점수의 최댓값을 저장
    
    for score in scores:  # 첫 번째 점수가 큰 순서대로 순회
        # print(score)
        if score[1] >= max_second:  # 두 번째 점수가 지금까지의 최댓값보다 크거나 같으면
            heapq.heappush(qualified, -sum(score))  # 합계의 음수를 저장 (최대 힙)
            max_second = score[1]
    
    
    
    # 순위 계산
    wonho_sum = sum(wonho)
    rank = 1
    while qualified:
        curr_sum = -heapq.heappop(qualified)
        if curr_sum == wonho_sum:
            return rank
        if curr_sum > wonho_sum:
            rank += 1
            
    return rank
