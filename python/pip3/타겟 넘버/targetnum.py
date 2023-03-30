def main():
    print(solution([1, 1, 1, 1, 1],3))

def solution(numbers, target):
    answer = 0
    answer += dfs(0,numbers,0,target)
    return answer

def dfs(depth,numbers,number,target):
    answer = 0
    if depth == len(numbers):
        if target == number:
            return 1
        else: return 0
    else:
        answer += dfs(depth+1,numbers,number+numbers[depth],target)
        answer += dfs(depth+1,numbers,number-numbers[depth],target)
    return answer
if __name__ == "__main__":
    main()