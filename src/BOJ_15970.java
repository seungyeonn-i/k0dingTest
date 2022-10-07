import java.util.ArrayList;
import java.util.Collections;

public class BOJ_15970 {

    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] a;

    static void input() {

        N = sc.nextInt();
        a = new ArrayList[N + 1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<Integer>();
        }
        for(int i=1;i<=N;i++){
            int coord,color;
            coord = sc.nextInt();
            color = sc.nextInt();
            //TODO: color 인 색깔의 점이 coord에 놓여 있음
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int index) {
        if (index == 0)
            return Integer.MAX_VALUE;
        return a[color].get(index) - a[color].get(index - 1);

    }
    static int toRight(int color, int index) {
        if (index + 1 == a[color].size())
            return Integer.MAX_VALUE;
        return a[color].get(index + 1) - a[color].get(index);

    }

    static void pro() {
        //TODO : 색깔별로 정렬하기
        for (int color = 1; color <= N; color++)
            Collections.sort(a[color]);

        int ans = 0;

        //TODO: 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
        for (int color = 1; color <= N; color++) {
            for (int i = 0; i < a[color].size(); i++) {
                int left_distance = toLeft(color, i);
                int right_distance = toRight(color, i);
                ans += Math.min(left_distance, right_distance);
            }
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
