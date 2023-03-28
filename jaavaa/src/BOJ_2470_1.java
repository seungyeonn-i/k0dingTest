import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_1 {
    /**
     * 서로 다른 두 용액을 더해서 합이 최대한 0에 가깝게
     */
    static int N;
    static int[] A,cnt;

//    scanner
    static MyScanner2470 sc = new MyScanner2470();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }

    }

    static void pro() {

        Arrays.sort(A, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 1, R = N;

        while (L < R) {
            int sum = A[L] + A[R];
            if (Math.abs(sum) < best_sum) {
                best_sum = Math.abs(sum);
                v1 = A[L];
                v2 = A[R];
            }
            if (sum > 0) {
                R--;
            } else L++;

        }sb.append(v1).append(' ').append(v2);

    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
    }
}
class MyScanner2470{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner2470(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {

        while(st == null || !st.hasMoreElements()){
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