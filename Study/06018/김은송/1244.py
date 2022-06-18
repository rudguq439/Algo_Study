T = int(input())
switches = [0] + list(map(int, input().split()))
N = int(input())
students = [list(map(int, input().split())) for _ in range(N)]

for student, switch in students:
    if student == 1:
        for i in range(switch, T + 1, switch):
            if switches[i]:
                switches[i] = 0
            else:
                switches[i] = 1
    else:
        for i in range(T):
            if switch + i > T or switch - i < 1:
                break
            if switches[switch + i] == switches[switch - i]:
                if switches[switch + i]:
                    switches[switch + i] = 0
                    switches[switch - i] = 0
                else:
                    switches[switch + i] = 1
                    switches[switch - i] = 1
            else:
                break

for i in range(T // 20 + 1):
    for k in range(20 * i + 1, 20 * i + 21):
        if k > T:
            break
        print(switches[k], end=' ')
    print()