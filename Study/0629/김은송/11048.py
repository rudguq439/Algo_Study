N, M = map(int, input().split())
arr = []

for _ in range(N):
    arr.append(list(map(int, input().split())))

dr = [-1, 0, -1]
dc = [0, -1, -1]

for i in range(N):
    for j in range(M):
        compare = [0, 0, 0]
        for k in range(3):
            nr = i + dr[k]
            nc = j + dc[k]

            if 0 <= nr < N and 0 <= nc < M:
                compare[k] = arr[nr][nc]
        arr[i][j] += max(compare)

print(arr[N-1][M-1])
