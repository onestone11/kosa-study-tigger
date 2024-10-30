def solution(book_time):
    # [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
    book_times = [[timeto(i[0]), timeto(i[1]) + 10] for i in book_time]
    # [[900, 1030], [1000, 1110], [860, 930], [850, 1170], [1100, 1290]]
    book_times.sort()
    # [[850, 1170], [860, 930], [900, 1030], [1000, 1110], [1100, 1290]]

    rooms = []
    for book_time in book_times:
        if len(rooms) == 0:
            rooms.append(book_time)
            continue
        for room_num, room_time in enumerate(rooms): 
            # room[-1] : 체크 아웃 시간
            if book_time[0] >= room_time[-1]: # 다음 호텔의 체크 인 시간이 체크 아웃 시간보다 크면 같은 방
                rooms[room_num] = room_time + book_time # 해당하는 룸에 추가([860, 930, 1000, 1110]) 
                break
        else: # 위에서 조건 문이 성립 안하면 같은 방이 아님(뒤의 체크인 시간이 체크아웃 시간보다 빠르기 때문)
            rooms.append(book_time) # 방 하나 생성([] 배열 추가)
    # [[850, 1170], [860, 930, 1000, 1110], [900, 1030, 1100, 1290]]        
    return len(rooms)

# 분으로 바꿔주는 함수
def timeto(a):
    return (int(a[:2]) * 60) + int(a[3:]) 



book_time = [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]


print(solution(book_time))
