string = input()
ans = set()
N = len(string)

for i in range(N):
    for j in range(i, N):
        temp = string[i:j+1]
        ans.add(temp)

print(len(ans))
