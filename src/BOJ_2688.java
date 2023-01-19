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
        Dy = new long[65][10];

        // 초기값 구하기
        Dy[0][0] = 0;
        Dy[0][1] = 1;
        Dy[0][2] = 3;

        for (int j = 2; j <= 9; j++) {
            Dy[0][j] = Dy[0][j-1] + Dy[0][j-2];
        }

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 1; i < 65; i++) {
            for (int j = 2; j <= 9; j++) {
                Dy[i][j] = Dy[i][j-1] + Dy[i][j-2];
            }
        }

    }

    static void pro() {
        for (int rep = 1; rep <= Q; rep++) {
            int N = scan.nextInt();
            long ans = Dy[N][9];
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