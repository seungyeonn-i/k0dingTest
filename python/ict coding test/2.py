def maxTrailing(arr):
    diff = -1
    value = arr[0]
    
    for i in arr:
        if i > value:
            diff = max(diff, i - value)
        else:
            value = i
    
    return diff

arr=[2,1,9,10]
print(maxTrailing(arr))