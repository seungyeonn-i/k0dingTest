public class BOJ_11066 {
    static void preprocess(){
    }
    static void pro(){
        preprocess();
        dy = new int[K+1][K+1];

        for(int len=2;len<=K;len++){
            for(int i=1;i<=K-len+1;i++){
                j = i + len - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for(int k=1;k<j;k++){
                    dy[i][j] = Math.min(
                            dy[i][j],
                            dy[i][k]+dy[k+1][j] + sum[i][j]
                    );
                }
            }
        }

        System.out.println(dy[1][k]);

    }
}
