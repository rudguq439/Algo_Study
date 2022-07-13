# 1트. 13분
N = int(input())
books = dict()
best = ""


def check_best(best, book):
    if books[best] < books[book]:
        best = book
    elif books.get(best) == books[book]:
        temp = sorted([best, book])
        best = temp[0]
    return best


for i in range(N):
    book = input()

    if not i:
        best = book
        books[book] = 1
        continue

    if books.get(book):
        books[book] += 1
    else:
        books[book] = 1
    best = check_best(best, book)

print(best)

# ===================================================================================================
# # 다른 코드 - dict 함수가 아직 익숙하지 않아서, 나는 in, sorted 쓸 생각을 못 했다.
# # 난 best를 비울 수 없어서, 첫 input() 코드를 별개로 짰는데 이 코드는 따로 받을 필요가 없어서 훨씬 효율적인듯
# # htps://www.acmicpc.net/source/45148805
#
# N = int(input())
# books = {}
#
# for _ in range(N):
#     title = input()
#     if title in books:
#         books[title] += 1
#     else:
#         books[title] = 1
#
# # 사전순으로 정렬. dict을 정렬하면 튜플을 원소로 하는 배열로 반환하니까 dictionary 로 바꿔준다.
# books = dict(sorted(books.items()))
# # value 값이 최대인 키 값을 알고 싶으니까. max 함수는 최대 값이 여러 개인 경우, 인덱스가 가장 앞에 있는 값을 사용한다고 함.
# max_num = max(books, key=lambda x: books[x])
# print(max_num)
