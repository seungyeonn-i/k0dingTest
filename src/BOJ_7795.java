import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_7795 {

    /**
   */

    static MyScanner sc = new MyScanner();
    static StringBuilder sb = new StringBuilder();

    static int N,T,M;
    static ArrayList<Integer> A,B;

    static void input() {


            N = sc.nextInt();
            M = sc.nextInt();
            A = new ArrayList<>();
            B = new ArrayList<>();

            for(int j=0;j<N;j++){
                A.add(sc.nextInt());
            }
            for(int k=0;k<M;k++){
                B.add(sc.nextInt());
            }

    }

    static void pro() {

        int a=0;

        Collections.sort(A);
        Collections.sort(B);

        for (Integer integer : A) {
            for (Integer integer1 : B) {
                if (integer > integer1) {
                    a++;
                }
            }
        }
        sb.append(a+"\n");

    }

    public static void main(String[] args) {

        T = sc.nextInt();
        for(int i=0;i<T;i++){
            input();
            pro();
        }
        System.out.println(sb);
    }
}


class MyScanner{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}


