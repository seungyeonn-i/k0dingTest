import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068 {
    static int N,root,erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static MyScanner1068 sc = new MyScanner1068();
    static StringBuilder sb = new StringBuilder();



    static void input(){
        N = sc.nextInt();
        child = new ArrayList[N];
        leaf = new int[N];
        for(int i=0;i<N;i++) child[i] = new ArrayList<>();
        for(int i=0;i<N;i++){
            int par = sc.nextInt();
            if(par == -1){
                root = i;
                continue;
            }
            child[par].add(i);//자식 노드 기록
        }
        erased = sc.nextInt();
    }


    static void dfs(int x){
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }
        for(int y : child[x]){
            dfs(y);
            leaf[x] += leaf[y];
        }

    }
    static void pro() {
        // TODO : erased와 그의 부모 사이의 연결을 끊어주기
        for (int i = 0; i < N; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }
        // TODO : erased가 root인 예외 처리하기
        if (root != erased) dfs(root);
        // TODO : 정답 출력하기
        System.out.println(leaf[root]);
    }


    public static void main(String[] args) {
        input();
        pro();
    }
}

class MyScanner1068{
    BufferedReader br;
    StringTokenizer st;

    public MyScanner1068() {
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


