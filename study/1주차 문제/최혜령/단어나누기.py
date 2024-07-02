# https://www.acmicpc.net/problem/13023

def div_put(word):
    i = 1
    j = 2
    ls = []

    # slicing the word into three different parts
    while i < len(word)-1:
        tmp = ""
        first = word[0:i]
        second = word[i:j]
        third = word[j:]
        
        # for each part, if its length is longer than 1, reverse the string and put it into the temporary string object
        if len(first) > 1:
            tmp += first[::-1]
        else:
            tmp += first

        if len(second) > 1:
            tmp += second[::-1]
        else:
            tmp += second

        if len(third) > 1:
            tmp += third[::-1]
        else:
            tmp += third

        ls.append(tmp)
        if j == len(word)-1:
            j = i + 2
            i += 1
        else :
            j += 1

    # find out the most alphabetical first-ordered word from the sorted list
    result = sorted(ls)[0]

    return result

word = input().rstrip()

print(div_put(word))



