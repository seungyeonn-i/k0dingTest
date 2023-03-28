import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static boolean[] visit;
    static int[] dist;
    static int K,N;
    static int[] dir = {-1,+1,2};

    static MyScanner1697 sc = new MyScanner1697();

    static void input() {
        N = sc.nextInt();
        K = sc.nextInt();

        dist = new int[100005];
        visit = new boolean[100005];

    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        // TODO : 수빈이의 위치
        que.add(N);
        visit[N] = true;
        dist[N] = 0;

        // TODO : bfs 시작

        while (!que.isEmpty()) {
            int x = que.poll();
//            int y = x - 1; //여기를 바꿔가면서  {x-1,x+1,x*2}
            int y;
            for(int i=0;i<3;i++){
                if(i == 2)
                    y = x * dir[2];
                else
                    y = x + dir[i];

                if (0 <= y && y <= 100000 && !visit[y]) {
                    visit[y] = true;
                    dist[y] = dist[x] + 1;
                    que.add(y);
                }
            }

        }
    }
    static void pro(){
        bfs();
        System.out.println(dist[K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}


class MyScanner1697{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner1697() {
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


