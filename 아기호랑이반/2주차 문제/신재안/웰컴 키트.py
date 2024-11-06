n = int(input())
sizes = list(map(int, input().split()))
t, p = map(int, input().split())
t_order = 0

p1 = n // p
p2 = n % p

for size in sizes:
    t_order += size // t
    size = size % t
    if size > 0:
        t_order += 1
        
print(t_order)
print(f"{p1} {p2}")
