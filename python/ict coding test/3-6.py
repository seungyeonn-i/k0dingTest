
from collections import defaultdict

def tasks(n, a, b):

    graph = defaultdict(list)
    reverse_graph = defaultdict(list)

    for i in range(len(a)):
        graph[a[i]].append(b[i])
        reverse_graph[b[i]].append(a[i])
    
    def find():
        stack = []
        visited = [False] * (n + 1)

        def dfs(v):
            visited[v] = True
            for check in graph[v]:
                if not visited[check]:
                    dfs(check)
            stack.append(v)
        
        for i in range(1, n + 1):
            if not visited[i]:
                dfs(i)

        transposed_visited = [False] * (n + 1)
        arrs = []

        def reverse_dfs(v, arr):
            transposed_visited[v] = True
            arr.append(v)
            for check in reverse_graph[v]:
                if not transposed_visited[check]:
                    reverse_dfs(check, arr)

        while stack:
            v = stack.pop()
            if not transposed_visited[v]:
                arr = []
                reverse_dfs(v, arr)
                arrs.append(arr)

        return arrs

    arrs = find()

    count = sum(1 for arr in arrs if len(arr) > 1)
    
    return n - count
