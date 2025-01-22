l = int(input())
str_arr = input()

char_to_num = {chr(i): i - ord('a') + 1 for i in range(ord('a'), ord('z') + 1)}

num_arr = [char_to_num[char] for char in str_arr]

r = 1
m = 1234567891

sum = 0

for i in range(l):
    sum += num_arr[i] * r
    r *= 31

print(sum % m)
