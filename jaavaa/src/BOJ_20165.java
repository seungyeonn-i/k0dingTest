import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_20165 {

    // 시뮬레이션

    static int N,M,R,ans;
    static int[][] ground;
    static String[] round;
    static int[][] status;
//    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};

    static Scanner sc = new Scanner(System.in);

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        ground = new int[N + 1][M + 1];
        status = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int x = sc.nextInt();
                ground[i][j] = x;
                status[i][j] = x;
            }
        }

    }

    static void attack(int x , int y, int way) {
        // cnt ; 연쇄적으로 넘어질 도미노 개수
        // max(cnt-1,h-1)
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}}; //???????

        if(way == 'E') way = 0;
        else if(way == 'W') way = 1;
        else if(way == 'S') way = 2;
        else if(way == 'N') way = 3;

        int cnt = status[x][y];
        while (x > 0 && x <= N && y > 0 && y <= M && cnt > 0) {
            if(status[x][y] != -1 ) ans++;
            cnt = Math.max(cnt - 1, status[x][y] - 1);
            status[x][y] = -1;

            x += dir[way][0];
            y += dir[way][1];
        }
    }


    static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(status[i][j] == -1)
                    System.out.print("F");
                else System.out.print("S");
                if(j < M)  System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pro() {
        for (int rep = 1; rep <= R; rep++) {
            int x,y;
            String dir;

            x = sc.nextInt();
            y = sc.nextInt();
            dir = sc.next();
            attack(x, y, dir.charAt(0));

            x = sc.nextInt();
            y = sc.nextInt();
            status[x][y] = ground[x][y];

        }
        print();
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
