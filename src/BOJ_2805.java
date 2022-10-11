import java.util.Scanner;

public class BOJ_2805 {

    static int N,M;
    static int[] arr;
    static Scanner sc = new Scanner(System.in);
    static StringBuilder stringBuilder = new StringBuilder();
    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static boolean determination(int H) {
        // H 높이로 나무를 잘랐을 때 M만큼 얻을 수 있으면 true, 없으면 false
        // 자른 나무의 총 길이 합 long 이여야함

        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] > H) {
                sum += arr[i] - H;
            }
        }
        return sum >= M;    // M 이상 얻을 수 있으면 true
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;

        //[L .. R]사이에 정답 존재한다
        //TODO : 이분 탐색과 determination 문제를 이용해 answer 구하기

        while (L <= R) {
            long mid = (int) ((L + R) / 2);

            if (determination((int)mid)) {
                ans = mid;       //가능하면 저장
                L = mid + 1;    //하고 왼쪽 떙겨오기
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
