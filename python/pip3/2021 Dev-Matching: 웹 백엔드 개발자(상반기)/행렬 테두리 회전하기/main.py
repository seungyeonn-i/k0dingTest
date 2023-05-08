def main():
    solution(6,6,[[2,2,5,4],[3,3,6,6],[5,1,6,3]])

def solution(rows,columns,queries):
    answer = []
    cnt = 0
    # matrix = [[(rows*i)+(j+1) for j in range(columns) ] for i in range(rows)]
    
    x1,y1,x2,y2=queries[0][0]-1,queries[0][1]-1,queries[0][2]-1,queries[0][3]-1

    matrix = [i+1 for i in range(rows*columns)]

    print(x1,y1,x2,y2)
    for i in range(y1,y2+1):
        for j in range(x1,x2+1):
            print(i,j)


    return answer

    
if __name__ == "__main__":
    main()