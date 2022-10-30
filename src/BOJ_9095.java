import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9095 {
    static int T;
    static int[] dy;

    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();


    static void preprocessing() {
        dy = new int[15];

        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= 11; i++) { // i<=11까지, N으로 하면 안됨, proprocessing 이므로 N은 입력받기 전까지 0임.
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }
    }

    static void pro() {

        T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            sb.append(dy[N]).append('\n');
        }

        System.out.print(sb);

    }

    public static void main(String[] args) {
        preprocessing();
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
