n, m = map(int, input().split())
S = set()
cnt = 0
for i in range(n):
    S.add(input())

for i in range(m):
    candidate = input()
    if candidate in S:
        cnt += 1
print(cnt)
