# 1트: 12분 - 시간 초과!
# 2트: 22분 - 딕셔너리 사용을 떠오르는데 시간이 많이 걸렸다.
# 더 나은 듯한 코드: https://gudwns1243.tistory.com/52
N = int(input())
nums = list(map(int, input().split()))
# 중복 제거 후 오름차순 정렬
sorted_nums = sorted(list(set(nums)))
dict_nums = dict()
# 정렬된 배열의 값을 key, idx를 value 로 딕셔너리 생성
for i in range(len(sorted_nums)):
    dict_nums[sorted_nums[i]] = i
# 기존에 들어온 배열을 원래 순서대로 탐색하여 value 들고오기
for i in range(N):
    print(dict_nums[nums[i]], end=" ")
