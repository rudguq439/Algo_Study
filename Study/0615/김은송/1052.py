N, K = map(int, input().split())
times = 0
ones = []
ans = 0

while N > 0:
    if N % 2:
        ones.append(times)
    times += 1
    N //= 2

if len(ones) > K:
    ans = 2**(ones[len(ones)-K])
    for i in range(len(ones)-K):
        ans -= 2**ones[i]
print(ans)

