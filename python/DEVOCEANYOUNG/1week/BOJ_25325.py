n = int(input())
student = input().split()
names = {name:0 for  name in student}
for _ in range(n):
    likes = list(input().split())
    for j in likes:
        names[j] +=1

sorted_names = sorted(names.items(),key=lambda x: x[1], reverse=True) # x[1] 두번째 인자로 reverse로. 우선순위가 두번째 인자 
for key,value in sorted_names:
    print(key,value)
