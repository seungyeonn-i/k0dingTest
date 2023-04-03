from collections import deque
import math

def main():
    print(solution([93, 30, 55],[1, 30, 5]))

def solution(progresses, speeds):
    answer = []
    
    for i in range(len(progresses)):
        progresses[i] = math.ceil((100 - progresses[i]) / speeds[i])
            
    queue = deque([progresses[0]])
    index = 1
    while queue and index < len(progresses):
        if progresses[index] <= queue[0]:
            queue.append(progresses[index])
        else:
            answer.append(len(queue))
            queue.clear()
            queue.append(progresses[index])
        index += 1
        
    answer.append(len(queue))
    
    return answer
    
if __name__ == "__main__":
    main()