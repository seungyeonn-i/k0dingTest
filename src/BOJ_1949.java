import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1949 {

    // 인접하지 않은 마을들을 골라 주민 수 총합을 극대화
    static int[][] dy;
    static int[] num;
    static ArrayList<Integer> con[];
    static int N;

    static MyReader sc = new MyReader();
    StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        num = new int[N + 1];
        con = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
            con[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            con[x].add(y);
            con[y].add(x);
        }
    }
    static void dfs(int x, int prev){
        dy[x][0] = 0;
        dy[x][1] = num[x];

        for(int y : con[x]){
            if(y == prev) continue;
            dfs(y,x);
            dy[x][0] += Math.max(dy[y][0],dy[y][1]);
            dy[x][1] += dy[y][0]; //??
        }
    }
    static void pro(){
        dy = new int[N+1][2];

        dfs(1,-1);

        System.out.println(Math.max(dy[1][0],dy[1][1]));
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class MyReader{
        BufferedReader br;
        StringTokenizer st;

        public MyReader() {
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


}

