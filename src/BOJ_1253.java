import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

    static int N;
    static int[] A;

    static MyScanner1253 sc = new MyScanner1253();

    static void input() {
        N = sc.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
    }


    static boolean func(int target_idx){
        // TODO : target_idx 번쨰 원소가 서로 다른 두 수의 합으로 표현 되는가
        int L = 1, R = N;
        int target = A[target_idx];
        while( L < R ){

            if(L == target_idx) L++;
            else if(R == target_idx) R--;
            else{
                if(A[L] + A[R] == target) return true;
                if(A[L] + A[R] > target) R--;           //가장 큰거랑 가장 작은거랑 더햇는데 크면 삭제해줌
                else L++;
            }
        }
        return false;
    }

    static void pro(){
        // TODO : 최소, 최대를 빠르게 알기 위한 정렬
        Arrays.sort(A, 1, N + 1);

        int ans = 0;
        for(int i=1;i<=N;i++){
            // TOOD : i번쨰 원소가 서로 다른 두 수의 합으로 표현이 되는가
            if(func(A[i]))
                ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
class MyScanner1253{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner1253() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        String str = "";
        while (st == null || !st.hasMoreElements()) {
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
