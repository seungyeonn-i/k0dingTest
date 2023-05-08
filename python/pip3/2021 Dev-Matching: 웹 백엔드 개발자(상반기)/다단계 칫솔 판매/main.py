import math
def main():
    print(solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],["young", "john", "tod", "emily", "mary"],[12, 4, 2, 5, 10]))

def solution(enroll, referral, seller, amount):
    answer = []
    people = zip(enroll,referral)

    people = {key:value for key,value in zip(enroll,referral)}
    money = {key:value*100 for key,value in zip(seller,amount)}

    for one in enroll:
        for i in seller :
            if one not in seller:
                money[one] = 0

    for one in money:
        ins = math.floor(money[one] * 0.1)
        money[one] -= ins
        if(people[one] != '-'):
            money[people[one]] += ins

    for ans in enroll:
        answer.append(money[ans])
    return answer


if __name__ == "__main__":
    main()