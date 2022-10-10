import java.util.ArrayList;
import java.util.Collections;

public class BOJ_15970 {

    /**
     *
     * 1. 정답의 최대치 확인
     * 점 두개 = 2 * 10^5
     * 최대치 = 2500 * 2 * 10^5 = 5 * 10^8
     *                                      -> Intger로 충분
     *
     * 2. 정렬을 하면, 각 원소마다 가장 가까운 원소가 자신 양 옆에 있다
     *
     */



    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    //TODO : 색깔마다 정렬 할 배열
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
        // TODO : 왼쪽으로 화살표를 그린다면, 화살표의 길이를 return
        if (index == 0) //왼쪽에 점 없음
            return Integer.MAX_VALUE;
        return a[color].get(index) - a[color].get(index - 1);   //자기 - 자기 앞 순번

    }
    static int toRight(int color, int index) {
        if (index + 1 == a[color].size()) //오른쪽에 점 없음
            return Integer.MAX_VALUE;
        return a[color].get(index + 1) - a[color].get(index);

    }

    static void pro() {
        //TODO : 색깔별로 정렬하기
        for (int color = 1; color <= N; color++)
            Collections.sort(a[color]);
        int ans = 0;

        for (int color = 1; color <= N; color++) {
            //TODO: 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
            for (int i = 0; i < a[color].size(); i++) {
                int left_distance = toLeft(color, i);   //지금 보고있는 색깔, 인덱스 왼쪽 점 까지의 거리
                int right_distance = toRight(color, i); //지금 보고 있는 색깔, 인덱스 오른쪽 점 까지의 거리
                ans += Math.min(left_distance, right_distance); //거리 최솟값
            }
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
