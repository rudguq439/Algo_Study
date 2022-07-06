from collections import deque

N = int(input())
K = int(input())
arr = [[0 for _ in range(N)] for _ in range(N)]
queue = deque()
snake = deque()
for _ in range(K):
    r, c = map(int, input().split())
    arr[r-1][c-1] = 1

L = int(input())
for _ in range(L):
    # L는 왼쪽으로(-1) 90도 D는 오른쪽으로 90도(+1)
    X, C = input().split()
    if C == "D":
        queue.append((int(X), 1))
    else:
        queue.append((int(X), -1))

d = 1
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
row = col = flag = 0
ans = 1
arr[row][col] = 2  # 뱀은 2로 표시
snake.append((row, col))
while True:
    if queue:
        X, move = queue.popleft()
    else:
        X = -1
    while ans <= X or X == -1:
        row = row + dr[d]
        col = col + dc[d]
        if 0 <= row < N and 0 <= col < N:  # 머리가 벽에 부딪히지 않으면
            if not arr[row][col]:  # 빈공간이라면
                tr, tc = snake.popleft()
                arr[tr][tc] = 0
            elif arr[row][col] == 2:
                flag = 1
                break
            arr[row][col] = 2
            snake.append((row, col))
            ans += 1
        else:
            flag = 1
            break
    if flag:
        break
    d = (d + move) % 4

print(ans)
