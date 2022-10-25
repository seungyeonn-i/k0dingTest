import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2252 {
    static int[] indeg;
    static int[][] adj;
    static int N;

    static StringBuilder sb = new StringBuilder();
    static MyScanner2252 sc = new MyScanner2252();

    static void input(){
        //Adjacent List 생성 및 indegree 계산하기
    }
    static void pro(){
        // 제일 앞에 "정렬될 수 있는" 정점 찾기

        // 정렬될 수 있는 정점이 있다면?
        // 1. 정렬 결과에 추가하기
        // 2. 정점과 연결된 간선 제거하기
        // 3. 새롭게 "정렬될 수 있는" 정점

        Deque<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){ // 정렬 할 수 있어서 정렬 결과에 추가
            if(indeg[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            sb.append(x).append(' ');

            for(int y : adj[x]){
                indeg[y]--; //감소 하고 나서
                if(indeg[y] == 0) queue.add(y); // indeg[y]==0인건 딱 한순간 밖에 없음

            }
        }
        System.out.println(sb);
    }

}



class MyScanner2252{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner2252() {
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


