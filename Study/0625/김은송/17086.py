from collections import deque

N, M = map(int, input().split())
arr = []
queue = deque()
drow = [-1, -1, -1, 0, 1, 1, 1, 0]
dcol = [-1, 0, 1, 1, 1, 0, -1, -1]
ans = 0
for i in range(N):
    temp = list(map(int, input().split()))
    arr.append(temp)

    for j in range(M):
        if temp[j]:
            queue.append((i, j, 0))

while queue:
    row, col, cnt = queue.popleft()
    if cnt > ans:
        ans = cnt
    for k in range(8):
        new_row = row + drow[k]
        new_col = col + dcol[k]

        if 0 <= new_row < N and 0 <= new_col < M and not arr[new_row][new_col]:
            arr[new_row][new_col] = cnt + 1
            queue.append((new_row, new_col, cnt+1))

print(ans)