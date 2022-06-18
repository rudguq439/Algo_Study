N, M = map(int, input().split())
floor = []
woods = 0

for _ in range(N):
    floor.append(input())

for row in range(N):
    for col in range(M):
        # 가로
        if col != M-1 and floor[row][col] == "-" and floor[row][col+1] == "|":
            woods += 1
        if col == M-1:
            if floor[row][M-1] == "-":
                woods += 1
        # 세로
        if row != N-1 and floor[row][col] == '|' and floor[row+1][col] == "-":
            woods += 1
        if row == N-1:
            if floor[row][col] == "|":
                woods += 1

print(woods)
