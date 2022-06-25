N, M = map(int, input().split())
arr = [list() for _ in range(N)]

visited = [0] * N
curr = 0
ans = 0

for i in range(M):
    A, B = map(int, input().split())
    # 양방향
    arr[A].append(B)
    arr[B].append(A)


def dfs(a, cnt):
    global ans
    # 다른 친구로 4번 연결되면 조건 만족
    if cnt == 4:
        ans = 1
        return

    for node in arr[a]:
        if not visited[node]:
            visited[node] = 1
            dfs(node, cnt+1)
            visited[node] = 0


for j in range(N):
    # 친구 없는데 돌릴 수는 없음
    if arr[j]:
        # 겹치면 안 되니까 표시
        visited[j] = 1
        dfs(j, 0)
        visited[j] = 0
    if ans:
        break

print(ans)
