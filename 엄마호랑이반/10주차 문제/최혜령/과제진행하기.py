def solution(plans):
    # 시간을 분 단위로 변환하는 함수
    def to_minutes(time_str):
        h, m = map(int, time_str.split(":"))
        return h * 60 + m
    
    # 데이터 전처리: 시작 시간을 분으로 변환하고 소요시간도 정수로 변환
    tasks = []
    for name, start, duration in plans:
        tasks.append([name, to_minutes(start), int(duration)])
    
    # 시작 시간 기준으로 정렬
    tasks.sort(key=lambda x: x[1])
    
    stack = []  # 중단된 과제를 저장할 스택
    answer = []  # 완료된 과제 순서
    
    for i in range(len(tasks)-1):
        current_task = tasks[i]
        next_task = tasks[i+1]
        
        current_name, current_start, current_duration = current_task
        next_start = next_task[1]
        
        # 현재 과제 완료 시각
        current_end = current_start + current_duration
        
        # 다음 과제 시작 전에 현재 과제를 완료할 수 있는 경우
        if current_end <= next_start:
            answer.append(current_name)
            
            # 남는 시간 동안 이전에 중단된 과제 처리
            extra_time = next_start - current_end
            while extra_time > 0 and stack:
                suspended_name, remaining_time = stack.pop()
                if remaining_time <= extra_time:
                    answer.append(suspended_name)
                    extra_time -= remaining_time
                else:
                    stack.append([suspended_name, remaining_time - extra_time])
                    break
                    
        # 현재 과제를 완료하지 못하는 경우
        else:
            remaining = current_duration - (next_start - current_start)
            stack.append([current_name, remaining])
    
    # 마지막 과제 추가
    answer.append(tasks[-1][0])
    
    # 중단된 과제들을 순서대로 처리
    while stack:
        answer.append(stack.pop()[0])
    
    return answer
