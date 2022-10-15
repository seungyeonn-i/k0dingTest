import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7795 {

    /**
     * Binary Search ..
     * 정답의 최대치 4억 -> Integer .. 시간제한 1초
     * 1. 정렬 : O(M log M)
     * 2. 이분 탐색 : A의 원소마다 이분 탐색 -> O(N log M)

     */

    static MyScanners sc = new MyScanners();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B;

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        B = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            B[i] = sc.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        //TODO : A[L...R]에서 X미만의 수 중 제일 오른쪽 인덱스를 return하는 함수
        // 그런 게 없다면 L - 1 을 return 한다 왜 L - 1 ? :

        int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;

            if (A[mid] < X) {  //[L mid (X) R] 오른쪽으로 확대
                res = mid;
                L = mid + 1;   //[mid L (X) R]
            } else {          //[L (X) mid R] 오른쪽으로 확대
                R = mid - 1;  //[L (X) R mid]
            }
        }
        return res;
    }

    static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(B, 1, M + 1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는 지 count하기
            ans += lower_bound(B, 1, M, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int TT;
        TT = sc.nextInt();
        for (int tt = 1; tt <= TT; tt++) {
            input();
            pro();
        }
    }
}


class MyScanners{
    BufferedReader br;
    StringTokenizer st;

    public MyScanners() {
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


