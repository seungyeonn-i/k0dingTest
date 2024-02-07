graph={}

def tasks(n, a, b):
    depend = {a[i]: b[i] for i in range(len(a))}
    
    cnt = {i: 0 for i in range(1, n + 1)}
    for task in b:
        cnt[task] = cnt.get(task, 0) + 1
    
    double_depend = 0
    for i in range(len(a)):
        if a[i] in depend and b[i] in depend.values():
            if depend.get(b[i]) == a[i]:
                double_depend += 1
    
    double_depend = double_depend // 2

    answer = double_depend
    
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
