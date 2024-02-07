from collections import Counter

name = ["Apple", "Banana", "Apple", "Orange", "Grape", "Banana"]
price = [1, 2, 1, 3, 4, 2]
weight = [100, 200, 100, 150, 120, 200]

# zip을 사용하여 세 리스트를 묶음
zipped_items = zip(name, price, weight)

# name을 기준으로 정렬
sorted_items = sorted(zipped_items, key=lambda x: x[0])

# 중복된 요소의 개수를 세기 위해 Counter 사용
name_counter = Counter(item[0] for item in sorted_items)

# 중복된 요소와 갯수 출력
for item, count in name_counter.items():
    if count > 1:
        print(f"{item}: {count} 개")