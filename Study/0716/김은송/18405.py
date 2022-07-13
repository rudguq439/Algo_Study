# 1트. 16분 실패 - 이전 단계의 바이러스는 숫자가 작아도 바꾸면 안 되는데, 이 부분을 놓쳤음.
# 2트. 30분 성공 - dfs 로 풀었음
# 효율적인 풀이 - bfs 로 풀었으면 됐다!!! ㅜㅜ
from collections import deque

N, K = map(int, input().split())
arr = []
virus = []

for i in range(N):
    temp = list(map(int, input().split()))
    arr.append(temp)
    for j in range(N):
        if temp[j]:
            virus.append([temp[j], i, j])

S, X, Y = map(int, input().split())
moves = [(1, 0), (0, 1), (-1, 0), (0, -1)]
queue = deque()
for v in sorted(virus):
    queue.append((v[1], v[2], 0))

while queue:
    row, col, sec = queue.popleft()
    if sec >= S:
        break
    for dr, dc in moves:
        nr = dr + row
        nc = dc + col
        if 0 <= nr < N and 0 <= nc < N and not arr[nr][nc]:
            arr[nr][nc] = arr[row][col]
            queue.append((nr, nc, sec+1))

print(arr[X-1][Y-1])

# N, K = map(int, input().split())
# arr = []
#
# for _ in range(N):
#     arr.append(list(map(int, input().split())))
#
# S, X, Y = map(int, input().split())
# moves = [(1, 0), (0, 1), (-1, 0), (0, -1)]
# visited = [[0 for _ in range(N)] for _ in range(N)]
#
#
# def virus_breeding(cnt):
#     for r in range(N):
#         for c in range(N):
#             if arr[r][c] and visited[r][c] == cnt:
#                 v_num = arr[r][c]
#                 for dr, dc in moves:
#                     nr = dr + r
#                     nc = dc + c
#                     if 0 <= nr < N and 0 <= nc < N and (not arr[nr][nc] or arr[nr][nc] > v_num):
#                         # 2트 때 추가한 조건.
#                         if not visited[nr][nc] or visited[nr][nc] == cnt + 1:
#                             arr[nr][nc] = v_num
#                             visited[nr][nc] = cnt + 1
#
#
# for r in range(N):
#     for c in range(N):
#         if arr[r][c]:
#             visited[r][c] = 1
#
# for i in range(S):
#     virus_breeding(i+1)
#
# print(arr[X-1][Y-1])
