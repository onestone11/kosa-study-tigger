num = input()
numArr = []

for i in range(len(num)):
    numArr.append(int(num[i]))

for i in range(len(numArr)):
    maxIndex = i
    for j in range(i + 1, len(numArr)):
        maxIndex = j if numArr[maxIndex] < numArr[j] else maxIndex
    tmp = numArr[i]
    numArr[i] = numArr[maxIndex]
    numArr[maxIndex] = tmp

print(''.join(map(str, numArr)))
