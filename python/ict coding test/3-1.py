graph={}

def isCycle(v, visited, curr):
        if v not in visited:
            visited.append(v)
            curr.append(v)
            
        if v in graph:
            if graph[v] not in visited: 
                if isCycle(graph[v], visited, curr): # 인근값
                    return True
            elif graph[v] in curr:  
                return True
            
        curr.remove(v) 
        return False

def tasks(n, a, b):
    global graph
    for i in range(len(a)):
        graph[b[i]] = a[i]
    
    visited = []  
    curr = []  

    answer = 0
    for i in range(1, n+1):
        if i not in visited:
            if isCycle(i, visited, curr):
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
