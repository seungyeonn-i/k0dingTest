from collections import deque

# 보드의 크기
N = 5

# 상, 하, 좌, 우 이동 방향
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# 보드 입력 받기
board = []
for _ in range(N):
    row = list(map(int, input().split()))
    board.append(row)

# 학생의 현재 위치 입력 받기
r, c = map(int, input().split())

# 방문 체크 배열
visited = [[False] * N for _ in range(N)]

# 시작 위치를 큐에 추가하고 방문 체크
queue = deque([(r, c, 0)])
visited[r][c] = True

# BFS 탐색
while queue:
    curr_r, curr_c, move_count = queue.popleft()

    # 현재 위치에 1이 적혀 있으면 최소 이동 횟수 출력
    if board[curr_r][curr_c] == 1:
        print(move_count)
        break

    # 상, 하, 좌, 우로 이동하며 탐색
    for i in range(4):
        next_r = curr_r + dr[i]
        next_c = curr_c + dc[i]

        # 보드 범위 내에서 이동 가능한 칸이고 방문하지 않은 경우
        if 0 <= next_r < N and 0 <= next_c < N and board[next_r][next_c] != -1 and not visited[next_r][next_c]:
            queue.append((next_r, next_c, move_count + 1))
            visited[next_r][next_c] = True
else:
    # 1이 적혀 있는 칸에 도착할 수 없는 경우
    print(-1)