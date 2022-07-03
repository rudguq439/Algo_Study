# # 내 풀이
# N = int(input())
# M = int(input())
# S = input()
#
# ans = 0
# check = "I"
# check += "OI" * N
#
# C = len(check)
#
# for j in range(M-C+1):
#     if S[j] == "O":
#         continue
#     if S[j:j+C] == check:
#         ans += 1
#
# print(ans)

# 100점 풀이
# https://black-hair.tistory.com/135
N = int(input())
M = int(input())
S = input()
answer, i, count = 0, 0, 0

while i < (M - 1):
    if S[i:i+3] == 'IOI':
        i += 2
        count += 1
        if count == N:
            answer += 1
            count -= 1
    else:
        i += 1
        count = 0

print(answer)
