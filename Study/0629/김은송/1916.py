# # 내 풀이 - 시간 초과
# N = int(input())
# M = int(input())
#
# cities = [[] for _ in range(N+1)]
# mins = [0] * (N+1)
#
# for _ in range(M):
#     A, B, C = map(int, input().split())
#     cities[A].append((B, C))
#
# S, E = map(int, input().split())
# visited = [0] * (N+1)
#
#
# def dfs(city, steps):
#     if city == E:
#         return
#
#     for i, cost in cities[city]:
#         if not visited[i]:
#             if steps + cost < mins[i] or not mins[i]:
#                 mins[i] = steps + cost
#                 visited[i] = 1
#                 dfs(i, mins[i])
#                 visited[i] = 0
#
#
# visited[S] = 1
# dfs(S, 0)
# print(mins[E])

# 다익스트라
import heapq
N = int(input())
M = int(input())

INF = int(1e9)
routes =[[] for _ in range(N+1)]
for i in range(M):
    A, B, C = map(int, input().split())
    routes[A].append((B, C))

S, E = map(int, input().split())
dist = [INF] * (N+1)


def dijkstra(start):
    dist[start] = 0
    q = [(0, S)]

    while q:
        cost, cur = heapq.heappop(q)
        if dist[cur] < cost:
            continue

        for city, step in routes[cur]:
            new_cost = dist[cur] + step
            if dist[city] > new_cost:
                dist[city] = new_cost
                heapq.heappush(q, (new_cost, city))


dijkstra(S)
print(dist[E])

# https://cme10575.tistory.com/118
