import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static int N,M,V;
    static int adj[][];
    static boolean visited[];

    static MyScanner1260 sc = new MyScanner1260();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }

    }
    static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(' ');
//        for (int y : adj[x]) {
//            if(visited[y]) continue;
//            if(adj[x][y] == 0) continue;
//
//            dfs(y);
//        }

        for(int y=1;y<=N;y++){
            if(adj[x][y] == 0)  continue;
            if(visited[y]) continue;
            dfs(y);
        }

    }
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int x = que.poll();
            sb.append(x).append(' ');

//            for (int y : adj[x]) {
//                if(visited[y]) continue;
//                if(adj[x][y] == 0) continue;
//                que.add(y);
//                visited[y] = true;
//            }

            for (int y = 1; y <= N; y++) {
                if(adj[x][y] == 0)  continue;
                if(visited[y]) continue;

                que.add(y);
                visited[y] = true;
            }

        }

    }
    static void pro(){
        visited = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        for(int i=1;i<=N;i++) visited[i] = false;
        bfs(V);

        System.out.println(sb);


    }

    public static void main(String[] args) {
        input();
        pro();
    }

}

class MyScanner1260 {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner1260() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public Integer nextInt() {
        return Integer.parseInt(next());
    }
}
