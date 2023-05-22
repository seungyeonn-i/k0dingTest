def binary_search(arr,p):
    left,right = 0, len(arr)-1
    res = 0
    while left <= right:
        mid = (left + right) // 2
        if int(arr[mid][1]) >= p:
            right = mid -1
            res = mid
        else:
            left = mid + 1
    return res

n, m = map(int, input().split())
arr = [input().split() for _ in range(n)]

for _ in range(m):
    p = int(input())
    print(arr[binary_search(arr,p)][0])
