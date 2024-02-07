#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'getMinRooms' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY meetingTimings as parameter.
#
import heapq

def getMinRooms(meetingTimings):
    # Write your code here
    sorted_timings = sorted(meetingTimings, key=lambda x: x[0])
    min_heap = []  # 최소 힙

    for timing in sorted_timings:
        if min_heap and timing[0] >= min_heap[0]:
            heapq.heappop(min_heap)
        heapq.heappush(min_heap, timing[1])

    return len(min_heap)
            

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    meetingTimings_rows = int(input().strip())
    meetingTimings_columns = int(input().strip())

    meetingTimings = []

    for _ in range(meetingTimings_rows):
        meetingTimings.append(list(map(int, input().rstrip().split())))

    result = getMinRooms(meetingTimings)

    fptr.write(str(result) + '\n')

    fptr.close()
