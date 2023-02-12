def main():
    print(solution([44, 1, 0, 0, 31, 25],[31, 10, 45, 1, 6, 19]))

def solution(lottos,win_nums):
    answer = [0,0]
    index = [6,6,5,4,3,2,1]
    for i in range(6):
        if lottos[i] == 0:
            answer[0] += 1
            continue
        for j in range(6):
            if lottos[i] == win_nums[j]:
                answer[0]+=1
                answer[1]+=1
                break 

    ans = []
    ans.append(index[answer[0]])
    ans.append(index[answer[1]]) 
    return ans


if __name__ == "__main__":
    main()