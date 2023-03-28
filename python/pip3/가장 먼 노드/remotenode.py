from collections import deque
def main():
    print(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))

def solution(n,edge):
    answer = 0

    arr = [[]  for i in range (n+1)]
    visited = [0] *( n+1)

    for i , j in edge:
        arr[i].append(j)
        arr[j].append(i)
    
    visited[1] = 1

    bfs(1,arr,visited)

    for i in visited:
        if i == max(visited):
                answer += 1
    return answer


def bfs(start,arr,visited):
    que = deque([start]) # 양방향 큐

    while que:
        v = que.popleft() # Pop element from the start
        for i in arr[v]:
            if not visited[i]:
                visited[i] = visited[v] + 1
                que.append(i)
    
if __name__ == "__main__":
    main()