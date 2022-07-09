wheels = []
pointers = [0] * 4
ans = 0
# N = 0 S = 1
for _ in range(4):
    wheel_input = input()
    wheels.append(list(map(int, wheel_input)))

N = int(input())

for i in range(N):
    rotation = [0] * 4
    num, d = map(int, input().split())
    rotation[num-1] = d
    left = right = num - 1
    # 디를 따로 안 받아주면, 왼쪽 돌고 d 방향이 바뀌면 그 방향 그대로 right을 돌게 된다.
    leftd = rightd = d

    while left > 0:
        if wheels[left][(pointers[left]+6) % 8] != wheels[left-1][(pointers[left-1]+2) % 8]:
            leftd *= -1
            rotation[left-1] = leftd
        else:
            break
        left -= 1

    while right < 3:
        if wheels[right][(pointers[right]+2) % 8] != wheels[right+1][(pointers[right+1]+6) % 8]:
            rightd *= -1
            rotation[right+1] = rightd
        else:
            break
        right += 1

    for j in range(4):
        pointers[j] = (pointers[j] - rotation[j]) % 8

        if i == N-1:
            if wheels[j][pointers[j]]:
                ans += 2 ** j

print(ans)
