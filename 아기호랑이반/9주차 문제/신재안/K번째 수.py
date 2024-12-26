import sys
input = sys.stdin.readline

def quick_sort(arr, low, high, k):
    mid = int((low + high) / 2)
    arr[high], arr[mid] = arr[mid], arr[high]
    pivot = arr[high]
    i = low
    j = high - 1

    while i <= j:
        while arr[i] < pivot:
            i += 1
        while arr[j] > pivot:
            j -= 1

        if i <= j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1

    arr[i], arr[high] = pivot, arr[i]

    if i == k:
        print(arr[k])
        return
    elif i > k:
        quick_sort(arr, low, i - 1, k)
    else:
        quick_sort(arr, i + 1, high, k)

n, k = map(int, input().rstrip().split())
arr = list(map(int, input().rstrip().split()))

quick_sort(arr, 0, n-1, k-1)
