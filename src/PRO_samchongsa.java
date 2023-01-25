public class PRO_samchongsa {
    public static void main(String[] args) {
        int [] number = {0,0, 1,-1,0};

        int cnt = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i; j < number.length; j++) {
                for (int k = j; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0
                            && !(number[i] == number[j]) && !(number[i] == number[k]) && !(number[j]==number[k])) {
                        System.out.println("number[i]+number[j]+number[k] = " + number[i]+number[j]+number[k]);
                        cnt += 1;
                    }
                }
            }
        }

        System.out.println("cnt = " + cnt);

    }
}



