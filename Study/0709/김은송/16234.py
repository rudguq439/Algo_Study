from collections import deque

# 1트. 41분 21초.
# 디버깅 시점: visited 초기화 안 함/return 위치 실수/while문 flag 초기화 위치 선정 오판
N, L, R = map(int, input().split())
countries = []

for _ in range(N):
    countries.append(list(map(int, input().split())))

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]
ans = 0


def bfs():
    cnt = 0
    total = 0
    while queue:
        row, col = queue.popleft()
        visited[row][col] = 1
        cnt += 1
        total += countries[row][col]

        for i in range(4):
            nr = row + dr[i]
            nc = col + dc[i]
            if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc] and L <= abs(countries[row][col] - countries[nr][nc]) <= R:
                visited[nr][nc] = 1
                union.add((nr, nc))
                queue.append((nr, nc))

    return cnt, total


while True:
    flag = 0
    visited = [[0 for _ in range(N)] for _ in range(N)]
    for row in range(N):
        for col in range(N):
            if not visited[row][col]:
                union = set()
                queue = deque()
                queue.append((row, col))
                union.add((row, col))
                cnt, total = bfs()

                if cnt > 1:
                    flag = 1
                    usum = total // cnt
                    while union:
                        ur, uc = union.pop()
                        countries[ur][uc] = usum
    if not flag:
        break
    else:
        ans += 1
print(ans)

