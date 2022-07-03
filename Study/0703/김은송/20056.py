from collections import deque

N, M, K = map(int, input().split())

fireballs = deque()
check = set()
arr = [[[] for _ in range(N)] for _ in range(N)]
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]
ans = 0
# r, c, m, s, d => 위치 (r, c) 질량 m 속력 s 방향 d
for _ in range(M):
    r, c, m, s, d = map(int, input().split())
    arr[r-1][c-1] = [m, s, d, 1]
    fireballs.append((r-1, c-1, m, s, d))

for j in range(K):
    fbs = len(fireballs)
    for i in range(fbs):
        r, c, m, s, d = fireballs.popleft()
        nr = (r + dr[d] * s) % N
        nc = (c + dc[d] * s) % N

        if (nr, nc) in check:
            nm, ns, nd, cnt = arr[nr][nc]
            if nd >= 0 and nd % 2 != d % 2:
                nd = -1
            arr[nr][nc] = [nm+m, ns+s, nd, cnt+1]
        else:
            arr[nr][nc] = [m, s, d, 1]
            check.add((nr, nc))

    while check:
        r, c = check.pop()
        m, s, d, cnt = arr[r][c]
        if cnt > 1:
            nm = m // 5
            # 합쳐진 파이어볼의 개수
            ns = s // cnt
            if nm:
                if d < 0:
                    for k in range(4):
                        fireballs.append((r, c, nm, ns, k*2+1))
                else:
                    for k in range(4):
                        fireballs.append((r, c, nm, ns, k*2))
        else:
            fireballs.append((r, c, m, s, d))

for fireball in fireballs:
    ans += fireball[2]
print(ans)









