import java.io.*;
import java.util.*;
import java.lang.Math;

public class BOJ_2688 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int Q;
    static long[][] Dy;

    static void input(){
        Q = scan.nextInt();
    }

    static void preprocess() {
        Dy = new long[65][10];  // dy[자리수][시작하는 수]

        // 초기값 구하기
        for (int i = 0; i <= 9; i++) {
            Dy[1][i] = 1;
        }

        // 점화식을 토대로 Dy 배열 채우기

        // i자리의 j로 시작하는 수에 대한 줄어들지 않는 수의 개수는
        // (i - 1)자리의 j로 시작하는 수부터 (i - 1)자리의 9까지의 줄어들지 않는 수의
        // 개수를 더하면 된다.
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    Dy[i][j] += Dy[i - 1][k];
                }
            }
        }

    }

    static void pro() {
        for (int rep = 1; rep <= Q; rep++) {
            int N = scan.nextInt();
            long ans = 0;
            for (int i = 0; i <= 9; i++) {
                ans += Dy[N][i];
            }
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        preprocess();
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