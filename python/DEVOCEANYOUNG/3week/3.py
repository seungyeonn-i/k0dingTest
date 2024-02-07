#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'findLargestSquareSize' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY samples as parameter.
#

def findLargestSquareSize(samples):
    # Write your code here
    if not samples:
        return 0

    rows = len(samples)
    cols = len(samples[0])

    # Create a dynamic programming table to store the sizes of the largest square sub-matrices
    dp = [[0] * (cols + 1) for _ in range(rows + 1)]
    max_size = 0

    # Iterate through each cell in the matrix
    for i in range(1, rows + 1):
        for j in range(1, cols + 1):
            # If the current cell is defective (1), update the dp table
            if samples[i - 1][j - 1] == 1:
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
                max_size = max(max_size, dp[i][j])

    return max_size
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    samples_rows = int(input().strip())
    samples_columns = int(input().strip())

    samples = []

    for _ in range(samples_rows):
        samples.append(list(map(int, input().rstrip().split())))

    result = findLargestSquareSize(samples)

    fptr.write(str(result) + '\n')

    fptr.close()
