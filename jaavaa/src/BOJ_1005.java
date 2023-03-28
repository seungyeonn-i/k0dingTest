import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1005 {
    static int N,M;

    static ArrayList<Integer>[] adj;
    static int[] indeg; // 들어오는 간선 갯수
    static int[]T,T_done; // x별 소요 시간 , ???


    static MyScanner1005 sc = new MyScanner1005();
    static StringBuilder sb = new StringBuilder();

    static void input() {

        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        T = new int[N + 1];
        T_done = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            T[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }

    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if(indeg[i] == 0){
                queue.add(i);
                T_done[i] = T[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                T_done[y] = Math.max(T_done[y],T_done[x] + T[y]);
                // x를 기준으로, 기존 y와 x+y 중에 더 큰 값을 업데이트 해줌.
            }
        }
        int W = sc.nextInt();
        System.out.println(T_done[W]);
    }

    public static void main(String[] args) {
        int Q = sc.nextInt();
        while (Q > 0) {
            Q--;
            input();
            pro();
        }
    }


    static class MyScanner1005 {
    BufferedReader br;
    StringTokenizer st;

    MyScanner1005() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}}
