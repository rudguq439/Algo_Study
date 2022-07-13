# 1트. 5분 40초 - dict 활용법이 많이 부족하니까 익혀야 함.
N = int(input())
files = dict()

for _ in range(N):
    name, exe = input().split(".")
    if exe in files:
        files[exe] += 1
    else:
        files[exe] = 1

# 내 코드
# ans = dict(sorted(files.items()))
# for k, v in ans.items():
#     print(k, v)
# dict 으로 조회하면 더 빠르니까, 굳이 sort 하고 dict으로 다시 만들 필요 없음.
for key in sorted(files.keys()):
    print(key + " " + str(files[key]))
