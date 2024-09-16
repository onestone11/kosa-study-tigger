import sys

def find_best_diff(numbers, m):
    # Sort the numbers
    numbers.sort()
    
    best_diff = sys.maxsize
    left, right = 0, 1
    n = len(numbers)
    
    while left < n and right < n:
        diff = abs(numbers[left]-numbers[right])
        if diff == m:
            best_diff = diff
            break
        elif diff > m:
            if best_diff > diff:
                best_diff = diff
            left += 1
        else:
            right += 1
    
    return best_diff

# Reading input
n, m = map(int, sys.stdin.readline().rstrip().split())
numbers = [int(sys.stdin.readline().rstrip()) for _ in range(n)]

answer = find_best_diff(numbers, m)
print(answer)
