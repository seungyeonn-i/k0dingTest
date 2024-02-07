arr=[4,8,7]
low = [2,4]
high=[8,4]


def binary_search_left(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return left

def binary_search_right(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] <= target:
            left = mid + 1
        else:
            right = mid - 1
    return right


def countBetween(arr, low, high):
    results = []
    arr.sort()

    for i in range(len(low)):
        left = binary_search_left(arr, low[i])
        right = binary_search_right(arr, high[i])

        results.append(right - left + 1)

    return results

print(countBetween(arr,low,high))