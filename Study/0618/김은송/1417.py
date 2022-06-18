N = int(input())
dasom = 0
diffs = []
answer = 0

for i in range(N):
    if i:
        diff1 = int(input()) - dasom
        if diff1 >= 0:
            diffs.append(diff1)
    else:
        dasom = int(input())


def check_negative():
    for diff in diffs:
        if diff >= 0:
            return True
    return False


def earn_votes():
    max_diff = 0
    max_idx = 0

    for idx in range(len(diffs)):
        if diffs[idx] > max_diff:
            max_diff = diffs[idx]
            max_idx = idx
        diffs[idx] -= 1
    diffs[max_idx] -= 1
    return


while check_negative():
    answer += 1
    earn_votes()

print(answer)