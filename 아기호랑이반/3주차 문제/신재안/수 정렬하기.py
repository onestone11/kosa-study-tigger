n = int(input())

arr = [int(input()) for _ in range(n)]

for i in range(1, len(arr)):
    tmp = 0
    for j in range(len(arr) - i):
        if arr[j] > arr[j+1]:
            tmp = arr[j+1]
            arr[j+1] = arr[j]
            arr[j] = tmp
    if tmp == 0:
        break

for num in arr:
    print(num)
