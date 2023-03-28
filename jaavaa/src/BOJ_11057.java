public class BOJ_11057 {
    static int[][] dy;
    static int N;
    static void pro() {
        // 초기값 구하기
        for (int num = 0; num <= 0; num++) {
            dy[1][num] = 1;
        }
        // 점화식을 토대로 dy 배열 채우기
        for (int len = 2; len <= N; len++) {
            for (int num = 0; num <= 9; num++) {
                for (int prev = 0; prev <= num; prev++)
                    dy[len][num] += dy[len - 1][prev];
                dy[len][num] &= 10007; // ??
            }
        }

        // dy 배열로 정답 계산하기
        int ans = 0;
        for (int num = 0; num <= 9; num++) {
            ans += dy[N][num];
            ans %= 10007;
        }
        System.out.println(ans);
    }
}

