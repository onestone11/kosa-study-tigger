n, m  = map(int , input().split())

# 각 노드의 부모를 자기 자신으로 초기화
p = [i for i in range(n+1)]

# 루트 노드를 찾는 Find 연산
def find(a):
    if p[a] != a:
        p[a] = find(p[a])
    return p[a]

# 두 노드를 같은 집합으로 합치는 Union 연산
def union(a, b):
    a = find(a)
    b = find(b)
    if a < b: # 더 작은 값이 부모 노드가 될 수 있도록
        p[b] = a
    else:
        p[a] = b

for _ in range(m):
    a, b = map(int, input().split())
    union(a, b)


a = list(map(int, input().split()))
answer = 0

for i in range(n-1):
    if find(a[i]) != find(a[i+1]):
        answer += 1
print(answer)
