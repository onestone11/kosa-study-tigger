def need_partitions(start, end):
    x1, y1 = start
    x2, y2 = end
    partitions = []
    for i in range(min(x1,x2), max(x1,x2)+1):
        for j in range(min(y1,y2), max(y1,y2)+1):
            partitions.append((i,j))
    return partitions

def count_distance(a, b):
    return abs(a[0]-b[0]) + abs(a[1]-b[1])

def solution(places):
    answer = []
    players = {}
    for n in range(len(places)):
        place = places[n]
        tmp = []
        for i in range(len(place)):
            for j in range(len(place[i])):
                if place[i][j] == "P":
                    tmp.append((i,j))
        players[n] = tmp
    
    for key, value in players.items():
        if len(value) == 0:
            answer.append(1)
        else:
            matched = 1
            for i in range(len(value)-1):
                p1 = value[i]
                for j in range(i+1, len(value)):
                    p2 = value[j]
                    #print("room {}: {}\t{}".format(key, p1, p2))
                    if count_distance(p1, p2) <= 2:
                        invalids = need_partitions(p1, p2)
                        if p1 in invalids:
                            invalids.remove(p1)
                        if p2 in invalids:
                            invalids.remove(p2)
                        if len(invalids) == 0:
                            #print("room {}: {}\t{}".format(key, p1, p2))
                            matched = 0
                        else:
                            for elem in invalids:
                                if elem != p1 and elem != p2:
                                    a, b = elem
                                    if places[key][a][b] != "X":
                                        #print("room {}: {}\t{}".format(key, p1, p2))
                                        matched = 0
            answer.append(matched)                        
             
    return answer


