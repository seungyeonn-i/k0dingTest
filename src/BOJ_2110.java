import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    /**
     * 최 대 거 리
     * 어떤 거리만큼 거리를 둘 때 공유기 c개를 설치할 수 있는가
     *
     */

    static int C,N;
    static int[] A;

    static MyScanner sc = new MyScanner();
    StringBuilder sb = new StringBuilder();
    static void input() {
        N = sc.nextInt();
        C = sc.nextInt();

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }


    }

    static boolean determination(int D) {
        // TODO : D만큼의 거리를 둔다면 C개 만큼 공유기를 설치할 수 있나

        // 가장 많이 설치해보자
        // 제일 왼쪽부터 설치, D만큼 거리를 두며 최대로 설치가 개수와 C를 비교
        int cnt = 1, last = A[1];   //설치 갯수, 마지막으로 설치한 index
        for (int i = 2; i <= N; i++) {
            //A[i] 번쨰 설치 가능?
            if (A[i] - last >= D) {
                cnt++;
                last = A[i];
            }
        }
        return cnt >= C;
    }


    static void pro() {
        // 빠른 determination을 위한 정렬
        int L = 1, R = 10000000, ans = 0;
        Arrays.sort(A,1,N+1);

        // [L ... R] 범위 안에 정답 존재
        // 이분 탐색과 determination 문제를 이용해 ans 구하기
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }


    public static void main(String[] args) {
        input();
        pro();
    }


}
class MyScanner{

    BufferedReader br;
    StringTokenizer st;

    public MyScanner(){
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

    Long nextLong() {
        return Long.parseLong(next());
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



