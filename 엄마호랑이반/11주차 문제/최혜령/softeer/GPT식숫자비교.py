import sys

n = int(sys.stdin.readline().strip())
nums = []

for _ in range(n):
    num = sys.stdin.readline().strip()
    if "." in num:
        integer, fraction = num.split(".")
    else:
        integer, fraction = num, ""
    nums.append((int(integer), fraction))

# 정렬 기준
nums = sorted(
    nums,
    key=lambda x: (x[0], 1 if x[1] else 0, int(x[1]) if x[1] else 0, len(x[1])),
)

# 출력
for integer, fraction in nums:
    if fraction == "":
        print(f"{integer}")
    else:
        print(f"{integer}.{fraction}")
