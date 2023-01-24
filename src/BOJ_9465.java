import java.io.*;
import java.util.*;
import java.lang.Math;

public class BOJ_9465 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[][] A;

    static void input(){
        N = scan.nextInt();
        A = new int[2][N + 1];
        Dy = new int[2][N + 1];
        for (int j = 0; j < 2; j++) { //초기화
            for (int k = 1; k <= N; k++) {
                A[j][k] = scan.nextInt();
            }
        }
    }

    static void pro() {
        // 초기값 구하기
//        Dy[1][0] = Dy[1][1] = Dy[1][2] = 1;
        Dy[0][1] = A[0][1];
        Dy[1][1] = A[1][1];

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 2; i <= N; i++) {
            Dy[0][i] = Math.max(Dy[1][i - 1], Dy[1][i - 2]) + A[0][i];
            Dy[1][i] = Math.max(Dy[0][i - 1], Dy[0][i - 2]) + A[1][i];
        }

        // Dy배열로 정답 계산하기
        int ans = Math.max(Dy[0][N], Dy[1][N]);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }

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