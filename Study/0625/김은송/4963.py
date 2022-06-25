from collections import deque

while True:
    w, h = map(int, input().split())
    if not w and not h:
        break
    queue = deque()
    arr = []
    islands = []
    ans = 0
    visited = [[0 for _ in range(w)] for _ in range(h)]

    for i in range(h):
        temp = list(map(int, input().split()))
        arr.append(temp)
        for j in range(w):
            if temp[j] == 1:
                islands.append((i, j))

    dr = [-1, -1, -1, 0, 1, 1, 1, 0]
    dc = [-1, 0, 1, 1, 1, 0, -1, -1]


    def check_end():
        while queue:
            row, col = queue.popleft()

            for k in range(8):
                nrow = row + dr[k]
                ncol = col + dc[k]

                if 0 <= nrow < h and 0 <= ncol < w and arr[nrow][ncol]:
                    if not visited[nrow][ncol]:
                        visited[nrow][ncol] = 1
                        queue.append((nrow, ncol))


    if islands:
        for r, c in islands:
            if not visited[r][c]:
                visited[r][c] = 1
                queue.append((r, c))
                check_end()
                ans += 1

    print(ans)
