import sys
def dfs(start, now, sum, cnt):
    global ans
    if cnt == n:
        if arr[now][start]:
            sum += arr[now][start]
            if ans > sum:
                ans = sum
        return

    if sum > ans:
        return

    for i in range(n):
        if not visited[i] and arr[now][i]:
            visited[i] = 1
            dfs(start, i, sum + arr[now][i], cnt + 1)
            visited[i] = 0

n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))

ans =  sys.maxsize
visited = [0] * n
for i in range(n):
    visited[i] = 1
    dfs(i, i, 0, 1)
    visited[i] = 0
print(ans)

