N, K = map(int, input().split())
monsters = list(map(int,input().split()))
people= list(map(int,input().split()))

total = sorted(zip(monsters, people), key=lambda x: x[0])

status = K
rescue = 0
i=0
while(status > 0):
    for j in range(i):
        status -= total[i][0]
        if(status <= 0): break
    if(status <= 0): break
    rescue += total[i][1]
    i+=1

print(rescue)