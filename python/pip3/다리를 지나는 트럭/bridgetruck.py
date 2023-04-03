def main():
    print(solution(2,10,[7,4,5,6]))

def solution(bridge_length, weight, truck_weights):
    answer = 0
    que = [0 for _  in range(bridge_length)]
    while(que):
        que.pop(0)
        answer+=1

        if truck_weights:
            if truck_weights[0] + sum(que) <= weight:
                t = truck_weights.pop(0)
                que.append(t)
            else : que.append(0)
        
    return answer
    
if __name__ == "__main__":
    main()