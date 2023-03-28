import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2579 {
    static int[][] dy;
    static int N;
    static int[] A;

    static MyReader sc = new MyReader();

    static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        dy = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

    }

    static void pro(){

        // 초기값 구하기
        dy[1][0] = 0;
        dy[1][1] = A[1];

        if(N >= 2){
            dy[2][0] = A[2];
            dy[2][1] = A[1] + A[2];
        }

        // 점화식을 토대로 dy 배열 완성하기
        for(int i=3;i<=N;i++){
            dy[i][0] = Math.max(dy[i-2][1]+A[i],dy[i-2][0]+A[i]);
            dy[i][1] = dy[i-1][0] + A[i];
        }

        // dy 배열로 정답 계산하기
        int ans = Math.max(dy[N][0],dy[N][1]);
        System.out.println(ans);
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
