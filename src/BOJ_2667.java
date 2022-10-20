import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2667 {
    static int N,group_cnt;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir =  {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;


    static MyScanner2667 sc = new MyScanner2667();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        a = new String[N];

        for(int i=0;i<N;i++){
            a[i] = sc.nextLine();
        }
        visit = new boolean[N][N];


    }

    static void dfs(int x, int y) {
        group_cnt++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || ny >= N || nx >= N) continue;
            if(a[nx].charAt(ny) == '0') continue;
            if(visit[nx][ny]) continue;

            dfs(nx, ny);
        }

    }

    static void pro() {
        group = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);

                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for(int cnt:group) sb.append(cnt).append('\n');
        System.out.println(sb);

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
class MyScanner2667{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner2667() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}


