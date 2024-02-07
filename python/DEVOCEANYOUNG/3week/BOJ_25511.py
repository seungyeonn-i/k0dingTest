
def find_depth(tree, values, root, target_value):
    queue = [(root, 0)]  
    depth = -1  

    while queue:
        node, curr_depth = queue.pop(0)

        if values[node] == target_value:
            depth = curr_depth
            break

        for child in tree[node]:
            queue.append((child, curr_depth + 1))

    return depth

n, k = map(int, input().split())
tree = [[] for _ in range(n)]

for _ in range(n - 1):
    p, c = map(int, input().split())
    tree[p].append(c)

values = list(map(int, input().split()))

    # 루트 정점부터 시작하여 깊이 찾기
depth = find_depth(tree, values, 0, k)

    # 결과 출력
print(depth)
