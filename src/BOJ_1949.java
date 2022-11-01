public class BOJ_1949 {
    static void dfs(int x, int prev){
        dy[x][0] = 0;
        dy[x][1] = num[x];

        for(int y : con[x]){
            if(y == prev) continue;
            dfs(y,x);
            dy[x][0] += Math.max(dy[y][0],dy[y][1];
            dy[x][1] += dy[y][0]; //??
        }
        static void pro(){
            dy = new int[N+1][2];

            dfs(1,-1);

            System.out.println(Math.max(dy[1][0],dy[1][1]);
        }

    }
