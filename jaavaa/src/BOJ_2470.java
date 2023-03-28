import java.util.Arrays;

public class BOJ_2470 {

    /**
     * -10만 ~ 10만 = 최대치 int 가능
     * TODO : A[left]랑 더해서 0 에 가까운 오른쪽 용액은?
     *  = "-A[left]" 와 가까울 수록 좋다 = 정렬하면 가장 가까운 원소 양옆에 있다.
     *  정렬하면, 1. 이분탐색 가능, 2. 가장 가까운 원소 빠르게 가능
     */
    static int N;
    static int[] arr;

    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

    }

    static int lower_bound(int[] A, int L, int R, int X) {
        //TODO : A[L .. R]에서 X **이상** 의 수 중 제일 왼쪽 인덱스를 return
        // 그런게 없다면 R + 1 return A[L X (X+1) R]

        int res = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            //** warning X **이상** 의 수 중 가장 왼쪽 인덱스.
            if (A[mid] >= X) {// A[L X mid R res]
                res = mid;
                R = mid - 1;  // A[L X R mid=res]
            } else {          // A[L mid X R res]
                L = mid + 1; // A[mid L X R res]
            }
        }
        return res;
    }
    static void pro() {
        //TODO : arr 이분탐색 할거니까 일단 정랼
        Arrays.sort(arr,1,N+1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N - 1; left++) {
            //TODO : arr[left] 용액을 쓸 것이니 -arr[left]와 가장 가까운용액을 자신의 오른쪽에서 찾자
            // = -arr[left]를 이분 탐색으로 찾자
            int res = lower_bound(arr, left + 1, N, -arr[left]);

            //TODO : arr[res - 1]와 arr[res] 중에 arr[left]랑 더했을 떄 정보 갱신
            if (left < res - -1  && Math.abs(arr[res - 1] + arr[left]) < best_sum) {
                best_sum = Math.abs(arr[left] + arr[res - 1]); //갱신

                v1 = arr[left];
                v2 = arr[res - 1];
            }

            if (res <= N && Math.abs(arr[res] + arr[left]) < best_sum) {
                best_sum = Math.abs(arr[left] + arr[res]);

                v1 = arr[left];
                v2 = arr[res];
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);



    }

    public static void main(String[] args) {
        input();
        pro();

    }
}
