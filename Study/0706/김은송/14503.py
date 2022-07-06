N, M = map(int, input().split())
r, c, d = map(int, input().split())
room = []

for i in range(N):
    room.append(list(map(int, input().split())))

# 북동남서. 왼쪽은 -1
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
ans = 1
visited = [[0 for _ in range(M)] for _ in range(N)]
visited[r][c] = 1
flag = 0

def rotation(row, col, direct):
    global ans, flag
    if flag == 1:
        return
    for j in range(1, 5):
        nd = (direct - j) % 4
        nr = row + dr[nd]
        nc = col + dc[nd]
        if 0 <= nr < N and 0 <= nc < M and not room[nr][nc] and not visited[nr][nc] and not flag:
            ans += 1
            visited[nr][nc] = ans
            rotation(nr, nc, nd)

    nd = (direct + 2) % 4
    nr = row + dr[nd]
    nc = col + dc[nd]
    if flag == 1:
        return
    if 0 <= nr < N and 0 <= nc < M and not room[nr][nc]:
        rotation(nr, nc, direct)
    flag = 1
    return

rotation(r, c, d)
print(ans)
# https://www.acmicpc.net/source/45052043 while문으로
