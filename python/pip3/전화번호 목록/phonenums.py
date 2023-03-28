def main():
    print(solution(["119", "97674223", "1195524421"]))

def solution(phone_book):
    phone_book.sort()    # 정렬해서 앞뒤 비교 가능한 자원들이 위치하도록 한다.
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]): return False
    return True
    
if __name__ == "__main__":
    main()