# 1트. 한 시간 넘음.
N = int(input())
seats = [[0 for _ in range(N)] for _ in range(N)]
stu_seats = [[] for _ in range(N**2+1)]
favs = [set() for _ in range(N**2+1)]
moves = [(1, 0), (0, -1), (-1, 0), (0, 1)]


def check_near(row, col):
    cnt = 0
    if not seats[row][col]:
        for dr, dc in moves:
            cr = row + dr
            cc = col + dc
            if 0 <= cr < N and 0 <= cc < N and not seats[cr][cc]:
                cnt += 1
    return cnt


def check_favs(fav_set, stu):
    curr_cnt = 0
    queue = list()

    for r in range(N):
        for c in range(N):
            cnt = 0
            if not seats[r][c]:
                for dr, dc in moves:
                    cr = r + dr
                    cc = c + dc
                    if 0 <= cr < N and 0 <= cc < N and seats[cr][cc] in fav_set:
                        cnt += 1
                if curr_cnt < cnt:
                    curr_cnt = cnt
                    queue = [(r, c)]
                elif curr_cnt == cnt:
                    queue.append((r, c))
    vac = -1
    r = c = 0

    if queue:
        for row, col in queue:
            temp2 = check_near(row, col)
            if temp2 > vac:
                vac = temp2
                r = row
                c = col
    else:
        for row in range(N):
            for col in range(N):
                temp2 = check_near(row, col)
                if temp2 > vac:
                    vac = temp2
                    r = row
                    c = col
    seats[r][c] = stu


for i in range(N**2):
    stu, f1, f2, f3, f4 = map(int, input().split())
    temp = {f1, f2, f3, f4}
    favs[stu] = temp
    if not i:
        seats[1][1] = stu
    else:
        check_favs(temp, stu)

ans = 0
for r in range(N):
    for c in range(N):
        cnt = 0
        for dr, dc in moves:
            cr = r + dr
            cc = c + dc
            if 0 <= cr < N and 0 <= cc < N and seats[cr][cc] in favs[seats[r][c]]:
                cnt += 1
        if cnt:
            ans += 10 ** (cnt-1)
print(ans)