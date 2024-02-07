#!/bin/python3

import math
import os
import random
import re
import sys



# Complete the tasks function below.
def tasks(n, a, b):

    graph = {i: [] for i in range(1, n+1)}

    for i in range(len(a)):

        graph[a[i]].append(b[i])
    
    def cycle(index, visited, now):
        visited[index] = True
        now[index] = True

        for check in graph[index]:

            if not visited[check]:
                if cycle(check, visited, now):
                    return True
            elif now[check]:
                return True
            
        now[index] = False

        return False
    
    visited = {i: False for i in range(1, n + 1)}
    now = {i: False for i in range(1, n + 1)}
    for index in range(1, n + 1):

        if not visited[index]:
            if cycle(index, visited, now):
                return n - 1
    
    return n

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

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

    # fptr.write(str(res) + '\n')

    # fptr.close()
print(res)