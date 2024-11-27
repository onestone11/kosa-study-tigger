import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville) # list를 heap으로 변환
    while scoville[0] < K:
        n = heapq.heappop(scoville) + (heapq.heappop(scoville) * 2)
        heapq.heappush(scoville, n)
        answer += 1
        if scoville[0] < K and len(scoville) == 1:
            return -1

    return answer

# print(solution([1, 2, 3, 9, 10, 12], 7))
