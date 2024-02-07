def isCycle(v, graph, visited, recStack):
    visited[v] = True
    recStack[v] = True

    # 현재 노드가 그래프에 있고, 다음 노드를 방문
    if v in graph:
        next_v = graph[v]
        if not visited[next_v]:
            visited[next_v] = True
            if isCycle(next_v, graph, visited, recStack):
                visited[next_v] = True
                return True
        elif recStack[next_v]:
            return True

    recStack[v] = False
    return False

def tasks(n, a, b):
    graph = {}
    for i in range(len(a)):
        graph[a[i]] = b[i]  # a[i] 작업이 b[i] 작업 전에 완료되어야 함을 나타냄
    
    visited = [False] * (n + 1)
    recStack = [False] * (n + 1)

    answer = 0
    for i in range(1, n+1):
        if not visited[i]:
            if isCycle(i, graph, visited, recStack):
                answer += 1
    
    return n - answer

n = int(input().strip())

a_count = int(input().strip())

a = []

for _ in range(a_count):
    a_item = int(input().strip())
    a.append(a_item)

b_count = int(input().strip())

b = []

for _ in range(b_count):
    b_item = int(input().strip())
    b.append(b_item)

res = tasks(n, a, b)

print(res)
