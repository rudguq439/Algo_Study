array = [0] * 1000001

for i in range(1, 1000001):
    if i > 3:
        array[i] = array[i-1] % 1000000009 + array[i-2] % 1000000009 + array[i-3] % 1000000009
    else:
        if i == 1:
            array[i] = 1
        if i == 2:
            array[i] = 2
        if i == 3:
            array[i] = 4

for _ in range(int(input())):
    n = int(input())
    ans = 0

    print(array[n] % 1000000009)







