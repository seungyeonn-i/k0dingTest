def countMatches(grid1, grid2):
    n = len(grid1)
    m = len(grid1[0])
    
    def dfs(grid, x, y, visited):
        if x < 0 or x >= n or y < 0 or y >= m or grid[x][y] == '0' or visited[x][y]:
            return
        visited[x][y] = True
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        for dx, dy in directions:
            dfs(grid, x + dx, y + dy, visited)
            
    def check_match(region1, region2):
        for x in range(n):
            for y in range(m):
                if (region1[x][y] and not region2[x][y]) or (region2[x][y] and not region1[x][y]):
                    return False
        return True
    
    visited1 = [[False] * m for _ in range(n)]
    visited2 = [[False] * m for _ in range(n)]
    regions1 = []
    regions2 = []
    
    for i in range(n):
        for j in range(m):
            if grid1[i][j] == '1' and not visited1[i][j]:
                dfs(grid1, i, j, visited1)
                regions1.append([[visited1[x][y] for y in range(m)] for x in range(n)])
                visited1 = [[False] * m for _ in range(n)]  # Reset visited for next region
                
            if grid2[i][j] == '1' and not visited2[i][j]:
                dfs(grid2, i, j, visited2)
                regions2.append([[visited2[x][y] for y in range(m)] for x in range(n)])
                visited2 = [[False] * m for _ in range(n)]  # Reset visited for next region
    
    count = 0
    for region1 in regions1:
        for region2 in regions2:
            if check_match(region1, region2):
                count += 1
                break  # Once a match is found, move to the next region in grid1
                
    return count

grid1_count = int(input().strip())

grid1 = []

for _ in range(grid1_count):
    grid1_item = input()
    grid1.append(grid1_item)

grid2_count = int(input().strip())

grid2 = []

for _ in range(grid2_count):
    grid2_item = input()
    grid2.append(grid2_item)

result = countMatches(grid1, grid2)

print(result)