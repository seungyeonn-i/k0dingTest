# 세번 이하의 이동으로 2개 이상의 사과를 먹으면 1 아니면 0

from collections import deque
global flag

graph=[]
for i in range(5):
    graph.append(list(map(int,input().split(" "))))

x,y=map(int,input().split(" "))

dx = [-1,1,0,0]
dy= [0,0,1,-1]

def bfs(x,y,apple,depth=0):

    queue = deque()
    queue.append((x,y))

    if depth >= 3 and apple >= 2:
        flag = True
        return 
    if depth >= 3 and apple < 2:
        return
    
    while(queue):
            x,y=queue.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or nx >= 5 or ny < 0 or ny >=5:
                    continue
                if graph[nx][ny] == -1:
                    continue
                if graph[nx][ny] == 1:
                    graph[nx][ny] = -1
                    bfs(nx,ny,apple+1,depth+1)
                if graph[nx][ny] == 0:
                    graph[nx][ny] = -1
                    bfs(nx,ny,apple,depth+1)
    
    if depth == 0:
        if flag:
            return 1
        return 0

print(bfs(x,y,0,0))