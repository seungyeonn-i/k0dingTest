def numDuplicates(name, price, weight):
    # Write your code here
    n = len(name)
    duplicates = 0

    # zipped_items = list(zip(name,price,weight))
    
    # sorted_items = sorted(zipped_items, key=lambda x: x[0])
    
       
    for i in range(n):
        is_duplicate = False
        for j in range(i + 1, n):
            if name[i] == name[j] and price[i] == price[j] and weight[i] == weight[j]:
                is_duplicate = True
                break

        if is_duplicate:
            duplicates += 1

    return duplicates