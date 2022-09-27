import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1015 {
    //자기보다 작은 수
    //자기랑 같은수

    static MyReader sc = new MyReader();
    static StringBuilder sb = new StringBuilder();

    static class boj1015 implements Comparable<boj1015> {
        /**
         * @param idx A 배열의 idx 위치를 기억하는 변수
         * @param num A[idx]의 원래 값
         */
        int num,index;

        @Override
        public int compareTo(boj1015 other) {
            // TODO
            // 정렬 조건에 맞게 정렬하기
            // 1. num 의 비내림차순(오름차순)
            // 2. num이 같으면 idx 오름차순
//            if(num != other.num)
            return num - other.num;
//            return other.index - index;
//             -> 이미 오름차순으로 들어온 B배열,
//             Tim sort는 Object 형식을 index로 오름차순 정리함 이미 동위원소 ~

        }
    }

    static int N;
    static int[] P;
    static boj1015[] B;

    static void input() {
        N = sc.nextInt();
        B = new boj1015[N];
        P = new int[N];
        for(int i=0;i<N;i++){
            B[i] = new boj1015();
            // TODO : Elem의 정의에 맞게 넣어주기
            B[i].num = sc.nextInt();
            B[i].index = i;
        }

    }

    static void pro() {
        // TODO: B 배열 정렬하기
        Arrays.sort(B);

        // TODO: B 배열의 값을 이용해서 P 배열 채우기

        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].index] = b_idx;
        }
        // TODO: P 배열 출력하기
        for(int i=0;i<N;i++){
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
