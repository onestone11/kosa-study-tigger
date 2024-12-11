def solution(n): 
    # 'n'은 하노이 탑 문제에서 옮길 원반의 수를 나타냄.

    def hanoi(start, target, temp, N):
        # 재귀적으로 하노이 탑 문제를 해결하기 위한 함수.
        # start: 현재 원반이 있는 기둥.
        # target: 원반을 옮길 목적지 기둥.
        # temp: 중간에 사용할 임시 기둥.
        # N: 현재 옮겨야 할 원반의 개수.

        if N == 1:
            # 원반이 1개인 경우, 단순히 시작 기둥에서 목표 기둥으로 옮기면 됨.
            return [[start, target]]
            # 반환값은 시작 기둥과 목표 기둥을 나타내는 리스트.

        # 원반이 N개인 경우:
        # 1. 상위 N-1개의 원반을 임시 기둥으로 옮긴다.
        # 2. 가장 큰 원반(N번째 원반)을 목표 기둥으로 옮긴다.
        # 3. 임시 기둥에 있던 N-1개의 원반을 목표 기둥으로 옮긴다.
        return (
            hanoi(start, temp, target, N - 1)  # 1단계: N-1개의 원반을 임시 기둥으로 옮김.
            + [[start, target]]               # 2단계: 가장 큰 원반을 목표 기둥으로 옮김.
            + hanoi(temp, target, start, N - 1) # 3단계: 임시 기둥에 있는 원반을 목표 기둥으로 옮김.
        )

    # 하노이 함수 호출: 시작 기둥 1에서 목표 기둥 3으로 n개의 원반을 옮김.
    return hanoi(1, 3, 2, n)
