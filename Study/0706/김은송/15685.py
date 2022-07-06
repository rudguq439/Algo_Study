N = int(input())
arr = [[0 for _ in range(101)] for _ in range(101)]
dr = [0, -1, 0, 1]
dc = [1, 0, -1, 0]
ans = 0


# 해당 드래곤 커브를 그리는 함수
def dragon_curve(r, c, d, g):
    queue = [d]

    for i in range(g+1):
        ql = len(queue)

        for j in range(ql):
            # 0세대는 처음 주어진 방향이며, 미리 넣어놓았으니 또 큐에 넣을 필요 없음.
            if not i:
                nd = queue[0]
            else:
                # 기존 찍은 점들을 다 90 돌려주면 해당 세대가 된다. 큐의 끝부터 방향을 90도 틀어가면서 커브를 만들어야 함.
                nd = (queue[ql-j-1] + 1) % 4
                queue.append(nd)
            r += dr[nd]
            c += dc[nd]
            arr[r][c] = 1


for _ in range(N):
    # x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다. (0 ≤ x, y ≤ 100, 0 ≤ d ≤ 3, 0 ≤ g ≤ 10)
    x, y, d, g = map(int, input().split())
    # 문제에 따르면 y가 행 x가 열. 1은 드래곤 커브의 점을 의미함.
    arr[y][x] = 1
    dragon_curve(y, x, d, g)

# 범위가 100이라 이중 for 문 돌림.
for k in range(100):
    for m in range(100):
        # 점의 좌, 하, 오른쪽 아래 대각선이 드래곤 커브에 해당되면, 정답 += 1
        if arr[k][m] and arr[k+1][m] and arr[k][m+1] and arr[k+1][m+1]:
            ans += 1
print(ans)



