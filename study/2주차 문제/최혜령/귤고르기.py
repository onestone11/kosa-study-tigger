def solution(k, tangerine):
    answer = 0
    
    box = {}
    for elem in tangerine:
        if elem not in box.keys():
            box[elem] = 1
        else:
            box[elem] += 1
    
    sorted_box = dict(sorted(box.items(), key=lambda x:x[1]))
    
    total = len(tangerine)
    delete = total - k
    print("Total : {}\tDelete : {}".format(total, delete))
    
    for elem in sorted_box.keys():
        if delete-sorted_box[elem] >= 0:
            answer+=1
            delete -= sorted_box[elem]
    return len(sorted_box.keys())-answer
