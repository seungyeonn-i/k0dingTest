#  만약 호무라의 방에 생성된 강아지의 수가M개의 닫힌 구간 중 하나 이상에 포함되게 된다면, 그 즉시 방에 생성된 모든 강아지가 사라지게 된다!
# 최소의 행동 횟수로 호무라의 집에 정확히 N마리의 강아지가 있도록 만들고 싶다.


N,M,A,B=input().split( )
restrict = [[]]
for i in range(M):
    restrict[i] = list(map(input(),int))

print(restrict)
