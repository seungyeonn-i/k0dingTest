def tasks(n, a, b):
    graph = {}
    for i in range(len(a)):
        # a[i]는 b[i] 작업 전에 완료되어야 함
        graph[b[i]] = a[i]
    
    visited = set()  # 방문한 노드를 추적
    recStack = set()  # 현재 탐색 중인 노드를 추적 (순환 찾기 위함)
    
    def isCyclic(v, visited, recStack):
        # 현재 노드를 방문한 것으로 표시하고 스택에 추가
        visited.add(v)
        recStack.add(v)
        
        # 현재 노드의 인접 노드를 탐색
        if v in graph:
            if graph[v] not in visited:  # 방문하지 않은 인접 노드가 있으면 탐색
                if isCyclic(graph[v], visited, recStack):
                    return True
            elif graph[v] in recStack:  # 현재 스택에 있는 인접 노드를 방문하면 순환 발생
                return True
        
        # 현재 노드의 탐색을 마치고 스택에서 제거
        recStack.remove(v)
        return False
    
    cyclicTasks = 0
    for i in range(1, n+1):
        if i not in visited:
            if isCyclic(i, visited, recStack):
                cyclicTasks += 1
    
    # 순환을 형성하는 작업을 제외한 최대 작업 수 계산
    return n - cyclicTasks



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
