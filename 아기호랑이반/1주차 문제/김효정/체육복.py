def solution(n, lost, reserve):
    # reserve_set : 여벌이 있는 학생 중 체육복을 잃지 않은 학생들의 집합
    reserve_set = set(reserve) - set(lost)
    
    # lost_set : 체육복이 없고 여벌도 없는 학생들의 집합
    lost_set = set(lost) - set(reserve)
    
    for i in sorted(reserve_set):
        if i - 1 in lost_set:  # 앞번호 학생이 체육복이 없는 경우
            lost_set.remove(i - 1)
        elif i + 1 in lost_set:  # 뒷번호 학생이 체육복이 없는 경우
            lost_set.remove(i + 1)
    
    # 체육수업을 들을 수 있는 학생의 최댓값
    return n - len(lost_set)
