import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144 {

    static int N;
    static int[] A;
    static int[] cnt = new int[10000 + 1];

    static MyScanner13144 sc = new MyScanner13144();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        cnt = new int[100000 + 1];
    }

    static void pro() {
        long ans = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            // TODO : R을 옮길 수 있을 만큼 옮긴다
            while(R+1 <= N && cnt[A[R+1]] == 0 ){
                R++;
                cnt[A[R]]++;
            }
            // TODO : 정답을 갱신한다
            ans += R - L + 1;
            // TODO : L을 옮겨주면서 A[L]의 개수를 감소시킨다.
            cnt[A[L]]--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();

    }
}
class MyScanner13144{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner13144() {
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
}
