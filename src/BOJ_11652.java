import java.util.Arrays;

public class BOJ_11652 {

    //-2^62 ~ 2^62는 long을 사용해야함
    //같은 정보들은 "인접해" 있을 것이다. -> arr[i] == arr[i-1]

    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] arr;

    static void input() {
        N = sc.nextInt();
        arr = new long[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = sc.nextLong();
        }
    }

    static void pro() {
        // TODO : arr 정렬
        Arrays.sort(arr,1,N+1);

        /**
        * @param mode : 최빈값,
        * @param modeCnt : 최빈값의 등장 횟수,
        * @param curCnt : 현재값(a[1])의 등장 횟수
         **/

        long mode = arr[1];
        int modeCnt = 1, curCnt = 1;

        //TODO : 2번 원소부터 차례로 보면서
        for (int i = 2; i <=N; i++) {
            if (arr[i] == arr[i-1]) {
                curCnt++;
            } else{
                curCnt = 1;
            }
            if (modeCnt < curCnt) { //최빈값 횟수, 최빈값 갱신
                modeCnt = curCnt;
                mode = arr[i];
            }
        }
        System.out.println(mode);

    }

    public static void main(String[] args) {
        input();
        pro();
    }
}


