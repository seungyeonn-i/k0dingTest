#!/bin/python3

import math
import os
import random
import re
import sys

def dfs(grid, n, x, y, visited):

    if x < 0 or x >=n or y < 0 or y >=n or grid[x][y] == '0' or visited[x][y]:
        return []
    
    visited[x][y] = True
    area = [(x, y)]

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    for i in range(4) :

        nx = x + dx[i]
        ny = y + dy[i]

        new = dfs(grid, n, nx, ny, visited)

        for check in new:
            if check not in area:
                area.append(check)

    return area

def find(grid,n):
    visited = [[False for _ in range(n)] for _ in range(n)]
    areas = []

    for i in range(n):
        for j in range(n):
            if grid[i][j] == '1' and not visited[i][j]:
                areas.append(dfs(grid, n,i, j, visited))

    return areas

def countMatches(grid1, grid2):

    n1=len(grid1)
    n2=len(grid2)
    areas1 = find(grid1,n1)
    areas2 = find(grid2,n2)

    answer = 0

    for area1 in areas1:
        if any(area1 == area2 for area2 in areas2):
            answer += 1

    return answer


# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

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

    # fptr.write(str(result) + '\n')

    # fptr.close()
