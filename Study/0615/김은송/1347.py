# 입력값
N = int(input())
moves = input()

# 행/열의 최소-최대 설정
max_row = min_row = max_col = min_col = 0
nrow = ncol = 0  # 현재 좌표
d = 0  # 방향
dr = [1, 0, -1, 0]  # 좌하우상. d에 따라 어떤 방향으로 가는지 결정
dc = [0, -1, 0, 1]

for i in range(N):
    if moves[i] == "F":  # F 인 경우
        nrow += dr[d]
        ncol += dc[d]
        # 움직일 칸이 기존 범위를 벗어날 경우, 범위 변경
        if d == 0 and nrow > max_row:
            max_row += 1
        elif d == 1 and ncol < min_col:
            min_col -= 1
        elif d == 2 and nrow < min_row:
            min_row -= 1
        elif d == 3 and ncol > max_col:
            max_col += 1
    # 오른쪽으로 방향 틀기
    elif moves[i] == "R":
        d = (d+1) % 4
    # 왼쪽으로 틀기
    else:
        d = (d+3) % 4

# 범위를 알아냈으니, 해당 범위의 미로 변수 작성
answer = [["#" for _ in range(max_col-min_col+1)] for _ in range(max_row-min_row+1)]

# 시작점 좌표 변경
nrow -= min_row
ncol -= min_col
answer[nrow][ncol] = "."

# 주어진 이동내역을 반대로 거슬러 올라감
for i in range(N):
    if moves[N-i-1] == "F":
        nrow -= dr[d]
        ncol -= dc[d]
        answer[nrow][ncol] = "."
    elif moves[N-1-i] == "L":
        d = (d+1) % 4
    else:
        d = (d+3) % 4

for ans in answer:
    for a in range(max_col-min_col+1):
        print(ans[a], end="")
    print()


