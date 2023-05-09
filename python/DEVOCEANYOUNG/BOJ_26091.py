n,m=  map(int, input().split())
arr=  list(map(int, input().split()))

# 최소 인원으로 능력치 충족하여 {많은 팀을 만들 수 있는} 팀원은 두명이다 .. 
arr.sort()
sum = 0
for i in range(n//2):
    if arr[i] + arr[n-i-1] >= m:
        sum += 1

print(sum)
    