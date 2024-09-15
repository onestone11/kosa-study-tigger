def reposition(pos, video_len, op_start, op_end):
    mm, ss = int(pos.split(":")[0]), int(pos.split(":")[1])
    pos_seconds = mm * 60 + ss

    stm, sts = int(op_start.split(":")[0]), int(op_start.split(":")[1])
    start_seconds = stm * 60 + sts

    em, es = int(op_end.split(":")[0]), int(op_end.split(":")[1])
    end_seconds = em * 60 + es

    vm, vs = int(video_len.split(":")[0]), int(video_len.split(":")[1])
    video_seconds = vm * 60 + vs
    
    # 1. 현재 10초 미만일 경우 -> 00분 00초로 리셋
    if pos_seconds < 0:
        return "00:00"
    # 2. 현재 비디오 길이보다 클 경우 -> 비디오 길이 맨끝으로 이동
    if pos_seconds >= video_seconds:
        return video_len
    # 3. 현재 인트로 구간일 경우 -> 인트로 끝지점으로 이동
    if start_seconds <= pos_seconds and pos_seconds <= end_seconds:
        return op_end
    
    # 그 외 : 현재 위치 그냥 리턴
    return pos

def reset_pos(pos, video_len, op_start, op_end, move):
    mm, ss = int(pos.split(":")[0]), int(pos.split(":")[1])
    if move == 0:
        return reposition(pos, video_len, op_start, op_end)
    if move == 1: # next called = + 10s
        ss += 10
        if ss >= 60:
            mm += 1
            ss -= 60
        if mm < 10:
            mm = "0{}".format(mm)
        if ss < 10:
            ss = "0{}".format(ss)
        pos = "{}:{}".format(mm, ss)
        return reposition(pos, video_len, op_start, op_end)
    if move == 2 : # prev called = -10s
        ss -= 10
        if ss < 0:
            ss += 60
            mm -= 1
        if mm < 0:
            mm = 0
            ss = 0
        if mm < 10:
            mm = "0{}".format(mm)
        if ss < 10:
            ss = "0{}".format(ss)
        pos = "{}:{}".format(mm,ss)
        return reposition(pos, video_len, op_start, op_end)
        
def solution(video_len, pos, op_start, op_end, commands):
    pos = reset_pos(pos, video_len, op_start, op_end, 0)
    for command in commands:
        if command == "next":
            pos = reset_pos(pos, video_len, op_start, op_end, 1)
        elif command == "prev":
            pos = reset_pos(pos, video_len, op_start, op_end, 2)
        
    return pos
