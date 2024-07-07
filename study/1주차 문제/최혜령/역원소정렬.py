import sys

# 전체 입력을 한 번에 읽기
input = sys.stdin.read().split()

# 첫 번째 입력은 숫자의 개수
loop = int(input[0])

# 나머지 숫자를 추출
elements = input[1:1+loop]

# 숫자를 뒤집어서 정수로 변환
reversed_numbers = [int(num[::-1]) for num in elements]

# 정렬
sorted_numbers = sorted(reversed_numbers)

# 출력
for num in sorted_numbers:
    print(num)
