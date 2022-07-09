# 스터디 설명 문제. 연쇄 작용이 일어난 후 위치 이동하는 방식이 떠오르니 않아서 다른 사람 풀이를 보고 아이디어를 참고했다. (코드는 내가 짬)
# 참고: https://chldkato.tistory.com/30
from collections import deque

board = []
for _ in range(12):
    board.append(list(input()))
# 상하좌우 이동하면서 같은 색깔이 있는지 확인해야 한다.
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
ans = 0

while True:
    visited = [[0 for _ in range(6)] for _ in range(12)]  # 해당 좌표를 확인적 있는 지 용도
    flag = 0  # 연쇄가 발생 했는지, 안 했는지 확인용

    for i in range(12):  # board 탐색
        for j in range(6):
            if board[i][j] != '.' and not visited[i][j]:  # 뿌요가 있고 방문한 적 없는 위치면
                queue = deque()
                chain = []  # 터질 때 "." 으로 바꿔야 하는데 연쇄할 좌표 기록용
                cnt = 1  # 현재 위치도 계산 해야 함
                queue.append((i, j))
                chain.append((i, j))
                visited[i][j] = 1
                color = board[i][j]

                while queue:  # 확인할 뿌요가 있을 때
                    row, col = queue.popleft()

                    for k in range(4):
                        nr = row + dr[k]
                        nc = col + dc[k]
                        if 0 <= nr < 12 and 0 <= nc < 6 and board[nr][nc] == color and not visited[nr][nc]:
                            cnt += 1  # 추가할 뿌요가 있을 때 갯수를 더해줌
                            visited[nr][nc] = 1
                            queue.append((nr, nc))
                            chain.append((nr, nc))

                if cnt >= 4:  # 4개 이상 뿌요가 연결된 상태이니
                    flag = 1  # 연쇄가 발생한다.
                    for r, c in chain:  # 터지는 짜요들을 "." 로 바꾸기
                        board[r][c] = "."

    if flag:  # 연쇄가 발생했다면,
        ans += 1
        for y in range(0, 6):
            x = 11
            down = 0  # 얼만큼 좌표 이동이 필요한가
            while 0 <= x:
                if board[x][y] == ".":
                    # . 이면 짜요가 아니니 이동할 필요는 없지만, 위에 짜요가 있으면 해당 짜요는 떨어져야 하니까, 얼만큼 떨어쟈야 하는지 저장
                    down += 1
                else:
                    # down이 0이면 떨어질 짜요도 없다는 얘기니 확인할 필요 없다.
                    if down:
                        # 짜요를 떨어져야 하는 위치로 교체
                        board[x+down][y] = board[x][y]
                        board[x][y] = "."
                x -= 1
    else:  # 연쇄가 없다면, while 문 탈출
        break

print(ans)
