import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_20164 {
    static int[] A;
    static int N;
    static ArrayList<Integer>d;
    static int ans_min,ans_max;

    static Scanner sc = new Scanner(System.in);

    static void input() {
        N = sc.nextInt();
    }

    //홀수 개수 리턴
    static int get_odd_cnt(int x) {
        int res = 0;

        String s = Integer.toString(x);
        String[] arr = s.split("");
        for (String t : arr) {
            if(Integer.parseInt(t) % 2 == 1) res++;
        }
        return res;
    }

    static void dfs(int x,int total_odd_cnt) {
        // 한자리수 일 경우, 종료
        if ( x < 10 ) { // ( x / 10 ) == 0
            ans_min = Math.min(ans_min, total_odd_cnt);
            ans_max = Math.max(ans_max, total_odd_cnt);
            return ;
        }
        // 두자리 수 일 경우, 나눠서 재귀 함수 호출
        if( x < 100 ){ // ( x / 100 ) == 0
            int next_x = (x/10) +(x%10);
            dfs(next_x, total_odd_cnt + get_odd_cnt(next_x));
            return;
        }
        // 세자리 수 이상이면 가능한 3가지 자르는 법 모두 진행
        String s = Integer.toString(x);
        for (int i = 0; i <= s.length() - 3; i++) {
            for (int j = i + 1; j <= s.length() - 2; j++) {
                String x1 = s.substring(0, i + 1); //s[0...i]
                String x2 = s.substring(i + 1, j + 1); //s[i+1...j+1]
                String x3 = s.substring(j + 1, s.length()); //s[j+1,end]

                int next_x = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
                dfs(next_x, total_odd_cnt + get_odd_cnt(next_x));
            }
        }
    }


    static void pro() {
        ans_min = 0x7fffffff;
        ans_max = 0;

        dfs(N, get_odd_cnt(N));
        System.out.println(ans_min + " " + ans_max);

    }

    public static void main(String[] args) {

        input();
        pro();
    }

}
