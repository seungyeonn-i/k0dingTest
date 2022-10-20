public class BOJ_14502 {

    static void bfs(int x, int y){
        // TODO : dist 배열 (갈 수 있으면 값, 없으면 -1) 초기화
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dist[i][j] = -1;
            }
        }
        // TODO : (x,y)를 que에 넣어주고, visit 표시와 dist 값 초기화
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        dist[x][y] = 1;
        visit[x][y] = true;

        // BFS 과정 시작
        while(!que.isEmpty(){
            int x = que.poll();
            int y = que.poll();

            for(int k=0;k<4;k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
                if(a[nx].charAt(ny) == '0') continue;
                if(visit[nx][ny]) continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1; // 하나 더 밟아준다.

            }
        }

    }
    static void pro(){
        // TODO : 시작점이 (0,0)인 탐색 시작
        bfs(0,0);
        // TODO : (N-1,M-1)까지 필요한 최소 이동 횟수 출력
        System.out.println(dist[N-1][M-1]);



    }

}
