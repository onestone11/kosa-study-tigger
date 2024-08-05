num = int(input())
result = input().rstrip().split(" ")

seq = False

total = 0

current = 1
for elem in result:
    if elem == '1' and seq == False:
        seq = True
        total += current
    elif elem == '1' and seq == True:
        current += 1
        total += current
    elif elem == '0' and seq == True:
        seq, current = False, 1

print(total)
