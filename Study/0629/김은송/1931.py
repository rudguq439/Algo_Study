N = int(input())
rooms = []

for _ in range(N):
    rooms.append(tuple(map(int, input().split())))

rooms.sort(key=lambda x: (x[1], x[0]))
now_start = 2**31 - 1
now_end = 2**31 - 1
ans = 0

for i in range(N):
    start, end = rooms[N-1-i]
    if end <= now_start:
        now_start = start
        now_end = end
        ans += 1

    if start > now_start:
        now_start = start
        now_end = end

print(ans)
