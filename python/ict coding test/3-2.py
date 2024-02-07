graph={}

def tasks(n, a, b):
    depend = {}
    redepend = {}
    for i in range(len(a)):
        depend[a[i]] = b[i]
        redepend[b[i]] = a[i]
    
    answer = 0
    for task in depend:
        if task in redepend and depend[task] == redepend[task]:
            answer += 1
    
    return n - answer


n = int(input().strip())

a_count = int(input().strip())

a = []

for _ in range(a_count):
    a_item = int(input().strip())
    a.append(a_item)

b_count = int(input().strip())

b = []

for _ in range(b_count):
    b_item = int(input().strip())
    b.append(b_item)

res = tasks(n, a, b)

print(res)
