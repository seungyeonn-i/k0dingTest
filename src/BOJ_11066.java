import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    static int[][]dy;
    static int K,Q;
    static int[][]sum;
    static int[] num;

    static MyReader sc = new MyReader();

    static void input() {
        K = sc.nextInt();
        num = new int[K + 1];
        sum = new int[K + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            num[i] = sc.nextInt();
        }
    }

    static void preprocess(){
        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                sum[i][j] = sum[i][j-1] + num[j];
            }
        }
    }
    static void pro(){
        preprocess();
        dy = new int[K+1][K+1];

        for(int len=2;len<=K;len++){
            for(int i=1;i<=K-len+1;i++){
                int j = i + len - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    dy[i][j] = Math.min(
                            dy[i][j],
                            dy[i][k]+dy[k+1][j] + sum[i][j]
                    );
                }
            }
        }

        System.out.println(dy[1][K]);

    }

    public static void main(String[] args) {
        Q = sc.nextInt();
        for (int rep = 1; rep <= Q; rep++) {
            input();
            pro();
        }
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
