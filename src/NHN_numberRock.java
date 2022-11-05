import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class NHN_numberRock {

        static int pw, N;
        static String input;
        //    static String[][] pws;
        static HashMap<Integer, String> pws;
        static int idx;
        static String str[] = new String[3];


        static MyScanner sc = new MyScanner();

        public static void main(String[] args) {
            input();
            if(first(input) == true){
//            second()
            }
            else{
                System.out.println("****");
            }

        }

        static void input() {
            pw = sc.nextInt();
            N = sc.nextInt();
            pws = new HashMap<>();
            for (int i = 1; i <= 1000; i++) {
                // 틀린 호수 찾기 위해
                pws.put(i, "0");
            }
            for (int i = 1; i <= N; i++) {
                int x = sc.nextInt();
                String s = sc.next();
                pws.put(x, s);
            }

            input = sc.next();
        }

        static int search(String input) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '#') {
                    return 11;
                }
                else if (input.charAt(i) == '*') {
                    return 31;
                }
                else if (input.charAt(i) == '!') {
                    return 22;
                }

            }
            return -1;
        }

        static boolean first(String input) {
            if (search(input) == 11) { // #
                //retry
                return false;
            }

            if (search(input) == 31) { // *
                //동호수 자르기
                int i=0;
                StringBuilder sb = new StringBuilder();
                while(input.charAt(i) != '*')
                    sb.append(input.charAt(i++));
                int dong = Integer.parseInt(String.valueOf(sb));
                sb = new StringBuilder();
                // 동호수 확인
                if(!pws.get(dong).equals("0")) {
                    // 비밀번호 확인
                    while (input.charAt(++i) != '*') {
                        sb.append(input.charAt(i));
                    }

                    int pw = Integer.parseInt(sb.toString());

                    String ss = pws.get(dong);
                    if(ss.equals(Integer.toString(pw))) {
                        // open
                        String p = sb.toString();
                        System.out.println(p.charAt(p.length()-4)+""+p.charAt(p.length()-3)+""+p.charAt(p.length()-2)+""+p.charAt(p.length()-1)+ " " + "OPEN");
//                        System.out.print(p.charAt(p.length()-1)+p.charAt(p.length()-2)+p.charAt(p.length()-3)+p.charAt(p.length()-4)+ " " + "OPEN");
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    return false;
                }
            }

            else if (search(input) == 22) { // !
                // 경비실 호출
                str = input.split("!");
                if(str.length==4)
                    System.out.print(str[0] + " CALL");
                else if (str.length == 3) {
                    System.out.print("0"+str[0] + " CALL");
                }else if (str.length == 2) {
                    System.out.print("00"+str[0] + " CALL");
                }else if (str.length == 1) {
                    System.out.print("000"+str[0] + " CALL");
                }

                return true;

            }


            return false;

        }




        static class MyScanner {
            BufferedReader br;
            StringTokenizer st;

            public MyScanner() {
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
                    str = st.nextToken(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }

        }
}

