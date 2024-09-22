def solution(video_len, pos, op_start, op_end, commands):
    pos = convertToSec(pos)
    op_start = convertToSec(op_start)
    op_end = convertToSec(op_end)
    video_end = convertToSec(video_len)

    if op_start < pos < op_end:
        pos = op_end

    for command in commands:
        if command == "next":
            pos += 10
        else:
            pos -= 10

        if pos >= video_end:
            pos = video_end
            
        if pos < 0:
            pos = 0
        
        if op_start <= pos < op_end:
            pos = op_end

    return convertToTimeFormat(pos)

def convertToSec(timeStr):
    timeList = timeStr.split(":")
    return int(timeList[0]) * 60 + int(timeList[1])

def convertToTimeFormat(sec):
    minutes = sec // 60
    sec = sec % 60
    
    minutes = "0" + str(minutes) if minutes < 10 else str(minutes)
    sec = sec = "0" + str(sec) if sec < 10 else str(sec)
        
    return minutes + ":" + sec
