def solution(strings, n):
    answer = []
    tmp = {}
    for elem in strings:
        if elem[n] not in tmp.keys():
            tmp[elem[n]] = [elem]
        else:
            tmp[elem[n]].append(elem)
    keys = []
    for key in tmp.keys():
        keys.append(key)
    sorted_keys = sorted(keys)
    for key in sorted_keys:
        if len(tmp[key]) > 1:
            tmp[key] = sorted(tmp[key])
        answer += tmp[key]
    return answer
