def solution(book_time):
    bookings = []
    for book in book_time:
        hour1, minute1 = map(int, book[0].split(":"))
        hour2, minute2 = map(int, book[1].split(":"))
        
        bookings.append([hour1*60+minute1, hour2*60+minute2+10])
    b = sorted(bookings)
    #print(b)
    stack = []
    for book in b:   
        time1, time2 = book
        if len(stack) == 0:
            stack.append(time2) #퇴실 시간 저장
        else:
            noRooms, roomNum = True, -1
            i = 0
            while i < len(stack) and noRooms:
                if stack[i] <= time1:
                    noRooms, roomNum = False, i
                i += 1
            if noRooms == True:
                stack.append(time2) #퇴실 시간 저장
            else:
                stack[roomNum] = (time2)
    #print(stack)
    return len(stack)
