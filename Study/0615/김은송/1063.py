king, stone, N = input().split()

now_king_row = int(king[1])
stone_row = int(stone[1])
col_index = ["A", "B", "C", "D", "E", "F", "G", "H"]

for i in range(8):
    if king[0] == col_index[i]:
        now_king_col = i
    if stone[0] == col_index[i]:
        stone_col = i


def check_inside(row, col):
    global stone_col, stone_row, now_king_col, now_king_row
    # 이동이 돌과 겹칠 때
    if now_king_row+row == stone_row and now_king_col+col == stone_col:
        if 0 <= col+stone_col < 8 and 1 <= row+stone_row < 9:
            stone_col += col
            stone_row += row
            return True
        return False
    # 안 겹치면 true
    return True


for _ in range(int(N)):
    move = input()
    if move == "R" and now_king_col != 7:
        if check_inside(0, 1):
            now_king_col += 1
    elif move == "L" and now_king_col != 0:
        if check_inside(0, -1):
            now_king_col -= 1
    elif move == "B" and now_king_row != 1:
        if check_inside(-1, 0):
            now_king_row -= 1
    elif move == "T" and now_king_row != 8:
        if check_inside(1, 0):
            now_king_row += 1
    elif move == "RT" and now_king_col != 7 and now_king_row != 8:
        if check_inside(1, 1):
            now_king_row += 1
            now_king_col += 1
    elif move == "LT" and now_king_col != 0 and now_king_row != 8:
        if check_inside(1, -1):
            now_king_row += 1
            now_king_col -= 1
    elif move == "RB" and now_king_col != 7 and now_king_row != 1:
        if check_inside(-1, 1):
            now_king_row -= 1
            now_king_col += 1
    elif move == "LB" and now_king_col != 0 and now_king_row != 1:
        if check_inside(-1, -1):
            now_king_row -= 1
            now_king_col -= 1

print(col_index[now_king_col]+str(now_king_row))
print(col_index[stone_col]+str(stone_row))
