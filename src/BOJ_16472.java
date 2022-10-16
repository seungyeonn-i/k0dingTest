import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16472 {

    static int N,kind;
    static String A;
    static int[] cnt;

    static MyReader16742 sc = new MyReader16742();

    static void input() {
        N = sc.nextInt();
        A = sc.nextLine();
        cnt = new int[26+1];

    }

    static void add(char x){
        cnt[x-'a']++;
        if(cnt[x-'a'] == 1){     //처음 들어온거니까 kind++
            kind++;
        }
    }
    static void erase(char x){
        cnt[x-'a']--;
        if(cnt[x-'a'] == 0){     //방금 나간거니까 kind--
            kind--;
        }
    }
    static void pro(){
        int len = A.length(), ans = 0;
        for(int R=0,L=0;R<len;R++){
            // TODO : R번째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // TODO : 불가능하면, 가능할 때까지 L을 이동
            while(kind > N){
                erase(A.charAt(L++));

                // TODO : 정답 갱신
                ans = Math.max(ans,R - L + 1);

            }
        }
        System.out.println(ans);


    }

    public static void main(String[] args) {
        input();
        pro();
    }
}

class MyReader16742{
    BufferedReader br;
    StringTokenizer st;

    public MyReader16742() {
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

