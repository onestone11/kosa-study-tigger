def solution(n):
    answer = 0

    def dfs(row, queens):
        nonlocal answer
        if row == n:  # 모든 퀸을 배치한 경우
            answer += 1
            return

        for col in range(n):  # 열을 탐색
            can_add = True
            for r, c in queens:  # 기존 퀸들과 충돌 여부 확인
                if c == col or abs(r - row) == abs(c - col):  # 같은 열 또는 대각선
                    can_add = False
                    break

            if can_add:
                dfs(row + 1, queens + [(row, col)])  # 퀸을 추가하고 다음 행으로 이동

    dfs(0, [])  # 초기 호출
    return answer
