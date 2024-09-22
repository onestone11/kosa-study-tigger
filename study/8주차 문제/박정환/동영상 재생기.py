def solution(video_len, pos, op_start, op_end, commands):
    def time(x):
        return int(x.split(':')[0])*60 + int(x.split(':')[1])

    video_len = time(video_len)
    pos = time(pos)
    op_start = time(op_start)
    op_end = time(op_end)

    for i in commands:
        if op_start <= pos <= op_end:
            pos = op_end
        if i == 'next':
            pos = min(video_len, pos+10)
        elif i == 'prev':
            pos = max(0, pos-10)

        if op_start <= pos <= op_end:
            pos = op_end

    m = str(pos//60) # 분
    s = str(pos%60) # 나머지 초

    if len(m) == 1:
        m = '0' + m
    if len(s) == 1:
        s = '0' + s

    return m+':'+s
