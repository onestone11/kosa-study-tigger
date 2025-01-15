def timeto(t):
    return int(t.split(':')[0]) * 60 + int(t.split(':')[1])

def change(music):
    exc = {'C#':'1','D#':'2', 'F#':'3', 'G#':'4', 'A#':'5', 'B#': '6'}
    for i, v in exc.items():
        music = music.replace(i,v)
    return music

def solution(m, musicinfos):
    a = []
    for i in musicinfos:
        i = i.split(',')
        i[3] = change(i[3])
        t_d = timeto(i[1]) - timeto(i[0])
        if t_d >= len(i[3]):
            M = i[3] * (t_d//len(i[3])) + i[3][:t_d % len(i[3])]
        else:
            M = i[3][:t_d]

        if change(m) in M:
            a.append([t_d, i[2]])

    if len(a) == 0:
        return "(None)"
    else:
        a.sort(key = lambda x: -x[0])
        return a[0][1]
    
print(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
