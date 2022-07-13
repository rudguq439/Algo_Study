# 1트. 7분 시간 초과!! 딕셔너리를 써야할까??
# 2트. 20분 - 런타임 에러(인덱스 에러)^^
# 3트. 31분 -

# 2트 + 3트
K, L = map(int, input().split())
students = dict()
ans = list()

for i in range(L):
    stu = input()
    students[stu] = i

for k, v in students.items():
    ans.append((k, v))

ans.sort(key=lambda x: x[1])
N = len(ans)
for j in range(K):
    # 예외 케이스 처리를 하지 않아서 런타임 에러가 났다.
    if j < N:
        print(ans[j][0])




