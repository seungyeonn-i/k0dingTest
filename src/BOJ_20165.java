import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_20165 {

    static int N,M,R;
    static int[][] ground;
    static String[] round;
    static int[][] status;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    static Scanner sc = new Scanner(System.in);

    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();

        ground = new int[N + 1][M + 1];
        status = new int[N + 1][M + 1];
        round = new String[2*R + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int x = sc.nextInt();
                ground[i][j] = x;
                status[i][j] = x;
            }
        }

        for (int k = 1; k <= R*2; k++) {
            round[k] = sc.nextLine();
        }
    }

    static void attack(int x , int y, int k, char way) {

        if(way=='E') way = 0;
        else if(way == 'W') way = 1;
        else if(way == 'S') way = 2;
        else if(way == 'N') way = 3;

        for(int i=0;i<k-1;i++){
            if(status[x+dir[way][0]][y+dir[way][1]] == -1 ) return ;
            if(x+dir[way][0] > N || y+dir[way][1] > M) return ;

            status[x+dir[way][0]][y+dir[way][1]] = -1;
            x += dir[way][0];
            y += dir[way][1];
        }
    }

    static void defense(int x, int y) {
        status[x][y] = ground[x][y];
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
        attack(3,1, status[3][1],'E');
        defense(3, 5);
        attack(5, 3, status[5][3], 'N');
        defense(3, 3);
        attack(5, 2, status[5][2], 'N');
        defense(3, 1);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println();
        print();
    }
}
