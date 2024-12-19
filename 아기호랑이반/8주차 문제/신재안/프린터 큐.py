t = int(input())

while t > 0:
    t -= 1
    n, m = map(int, input().split())
    queue = list(map(int, input().split()))
    order = list(range(n))
    cnt = 1

    while queue:
        priority = max(queue)
        if priority == queue[0]:
            queue.pop(0)
            if order.pop(0) == m:
                break
            cnt += 1
        else:
            queue.append(queue.pop(0))
            order.append(order.pop(0))

    print(cnt)
