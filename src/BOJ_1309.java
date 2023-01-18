import java.io.*;
import java.util.*;
import java.lang.Math;

public class BOJ_1309 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] dp;

    static void input(){

         N = scan.nextInt();
    }

    static void pro() {
        final int MOD = 9901;

        dp = new int[N + 1][3];

        // 초기값 구하기

        // dp[i][j] : i번째 줄의 j번째 칸에 동물을 놓을 수 있는 경우의 수
            // j = 0 : 아무 동물도 놓지 않음
            // j = 1 : 첫 번째 칸에 동물을 놓음
            // j = 2 : 두 번째 칸에 동물을 놓음

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        // Dy배열로 정답 계산하기
        int ans = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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