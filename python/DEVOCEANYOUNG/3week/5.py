def countWays(n):
    mod = 10**9 + 7

    # Initialize the dynamic programming array
    dp = [[0] * 4 for _ in range(n + 1)]
    
    # Base cases
    dp[1][1] = 1
    dp[1][2] = 1
    dp[1][3] = 1
    
    # Iterate over the houses
    for i in range(2, n + 1):
        # Calculate the number of colorings using one color
        dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod
        
        # Calculate the number of colorings using two colors
        dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod
        
        # Calculate the number of colorings using three colors
        dp[i][3] = (dp[i-1][1] + dp[i-1][2]) % mod
    
    # Return the total number of colorings for n houses
    return (dp[n][1] + dp[n][2] + dp[n][3]) % mod

# Test the function
n = 4
result = countWays(n)
print(result)