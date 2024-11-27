def solution(m, musicinfos):
    answer = "(None)"
    max_time = -1  # 가장 긴 음악의 길이를 추적할 변수
    
    # m 길이 계산
    m_length = 0
    ml = 0
    while ml < len(m):
        if ml < len(m) - 1 and m[ml + 1] == "#":
            m_length += 1
            ml += 2
        else:
            m_length += 1
            ml += 1
    
    # 음악 정보 처리
    for info in musicinfos:
        start, end, name, melodies = info.split(",")
        
        # 시간 계산
        start_h, start_m = map(int, start.split(":"))
        end_h, end_m = map(int, end.split(":"))
        start_total_minutes = start_h * 60 + start_m
        end_total_minutes = end_h * 60 + end_m
        music_length = end_total_minutes - start_total_minutes
        
        # 멜로디 처리
        all_melodies = []
        n = 0
        while n < len(melodies):
            if n < len(melodies) - 1 and melodies[n + 1] == "#":
                all_melodies.append(melodies[n:n + 2])
                n += 2
            else:
                all_melodies.append(melodies[n])
                n += 1
        
        # 음악 길이에 맞게 멜로디 생성
        melody = []
        if music_length <= len(all_melodies):
            melody = all_melodies[:music_length]
        else:
            repeat_count = (music_length // len(all_melodies)) + 1
            melody = (all_melodies * repeat_count)[:music_length]
        
        # melody에서 m이 포함되어 있는지 확인
        for rm in range(len(melody) - m_length + 1):
            current = melody[rm:rm + m_length]
            current_melody = "".join(current)
            
            if current_melody == m:
                # 일치하는 곡을 찾으면, 더 긴 곡으로 갱신
                if music_length > max_time:
                    max_time = music_length
                    answer = name
    
    return answer
