def main():
    arr = []
    for i in range(7):
        arr.append(list(map(int,input().split())))
        count(arr,i,j)

    print(arr)

def count(arr , i ,j ):
    if arr[i][j] == 0:
        return arr
    else:
        return arr
        
if __name__ == "__main__":
    main()
