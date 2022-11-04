import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_20167 {

    // 탈피 에너지 : 먹은 먹이 - K
    // 탈피 에너지의 최대값
    static long N,K,E,sum;
    static long[] a,dy;
    static ArrayList<Interval>[] intervals;

    static Scanner sc = new Scanner(System.in);
    static void input() {
        N = sc.nextLong();
        K = sc.nextLong();

        a = new long[(int) (N + 1)];
        dy = new long[(int) (N + 1)];
        intervals = new ArrayList[(int) N+1];
        for (int i = 0; i <= N; i++) {
            intervals[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
        }
    }

    static void dp() {
        int idx = 1;
        while(idx <= K){
            int sum = 0;
            while (sum < K && idx < K-3) {
                sum += Math.max(a[idx], a[idx + 1] + a[idx + 2]);
                System.out.println("+"+sum);
                if(Math.max(a[idx], a[idx + 1] + a[idx + 2]) == a[idx]) idx+=1;
                else idx +=3;
                System.out.println(idx);
            }
            E += sum - K;
            System.out.println(E);
        }

    }
    static class Interval{
        long left;
        long satisfy;
    }

    static void pro() {
        // dyLeftMax에 max(dy[1...(L-1)]값을 누적하기
        // L에 맞는 R 계산하기
        // L,R에 대해 얻는 만족도를 dy[R]에 갱신해주기
        // L을 한 칸 이동시킬 때의 sum 변화량 계산해주기

        for (int L = 1, R = 0; L <= N; L++) {
            while (sum < K && R + 1 <= N) {
                sum += a[++R];
            }
            if (sum >= K) {
                Interval i = new Interval();
                i.left = L;
                i.satisfy = sum - K;
                intervals[R].add(i);
            }
            sum -= a[L];
        }

        for (int R = 1; R <= N; R++) {
            dy[R] = dy[R - 1];
            for (Interval i : intervals[R]) {
                dy[R] = Math.max(dy[R],dy[(int) (i.left -1)] + i.satisfy)
            }
        }
        System.out.println(dy[(int) N]);
    }

    public static void main(String[] args) {
        input();
        dp();
    }

}
