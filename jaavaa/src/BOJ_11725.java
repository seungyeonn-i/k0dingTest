import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static MyScanner11725 sc = new MyScanner11725();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }
// 정점 x의 부모가 par, 였고, x의 children을 찾아주는 함수

    static void dfs ( int x, int par){
        for (int y : adj[x]) {
            if (y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    static void pro () {
        dfs(1, -1);
        for (int i = 2; i <= N; i++)
            sb.append(parent[i]).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
class MyScanner11725{
    BufferedReader br ;
    StringTokenizer st;

    MyScanner11725() {
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

}
