n = int(input())
str = input()
arr=list(str)

for i in range(arr):
    for j in range(arr):
        str.find(str(arr[i:j]))