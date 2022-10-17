- 이분 탐색

  ### **정렬이 보장되는** 배열에서 기준 X를 가지고 범위를 “이분” 하면서 탐색

                                                                                                                   → O(log N)

    - 알고리즘

      L : 탐색 할 가치가 있는 범위의 **왼쪽** 끝 인덱스

      R : 탐색 할 가치가 있는 범위의 **오른쪽** 끝 인덱스

      Result : 탐색한 X의 위치

    - 주의사항
        1. L과 R, Result의 초기값 설정 주의
        2. L과 R, Result의 변수들의 정의를 헷갈려 부등호 주의
    - **정렬이 보장되는** 배열에서 기준 X를 가지고 범위를 “이분” 하면서 탐색
        - ~~X가 존재하는지?~~
        - ~~X 이상,이하,초과,미만 의 원소는 몇개가 있는지?~~
        - ~~X랑 가장 가까운 원소는 무엇인지?~~

          → O(log N)

    - ** 오름차순 ** 정렬이 된 배열의 특성
        - M번 인덱스에 있는 A[M]이 X보다 작으면 A[M~끝] 모두 전부 X보다 크다.
        - M번 인덱스에 있는 A[M]이 X보다 크면 A[1~M] 모두 전부 X보다 작다.

    ---

    - BOJ_7795

        ```java
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;
        
        public class BOJ_7795 {
        
        /**
             * Binary Search ..
             * 정답의 최대치4억-> Integer ..시간제한1초
        		 * 1.정렬: O(M log M)
             * 2.이분 탐색: A의 원소마다 이분 탐색-> O(N log M)
        
             */
        
        static MyScannersc= new MyScanner();
            static StringBuildersb= new StringBuilder();
        
            static intN,M;
            static int[]A,B;
        
            static void input() {
        				N=sc.nextInt();
        				M=sc.nextInt();
        				A= new int[N+ 1];
        				B= new int[M+ 1];
                for (int i = 1; i <=N; i++) {
        					A[i] =sc.nextInt();
                }
                for (int i = 1; i <=M; i++) {
        					B[i] =sc.nextInt();
                }
            }
        
            static int lower_bound(int[] A, int L, int R, int X) {
                //TODO : A[L...R]에서 X미만의 수 중 제일 오른쪽 인덱스를 return하는 함수
        				// 그런 게 없다면 L - 1 을 return 한다 왜 L - 1 ? :
        
                int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
                while (L <= R) {
                    int mid = (L + R) / 2;
        
                    if (A[mid] < X) {  //[L mid (X) R] 오른쪽으로 확대
                        res = mid;
                        L = mid + 1;   //[mid L (X) R]
                    } else {          //[L (X) mid R] 오른쪽으로 확대
                        R = mid - 1;  //[L (X) R mid]
                    }
                }
                return res;
            }
        
            static void pro() {
                // TODO : B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
                Arrays.sort(B, 1,M+ 1);
        
                int ans = 0;
                for (int i = 1; i <= N; i++) {
                    // TODO : A[i]를 선택했을 때, B에서는 A[i]보다 작은게 몇개나 있는지 count하기
                    ans +=lower_bound(B, 1,M,A[i]);
                }
                System.out.println(ans);
            }
        
            public static void main(String[] args) {
                int TT;
                TT = sc.nextInt();
                for (int tt = 1; tt <= TT; tt++) {
        						input();
        						pro();
                }
            }
        }
        
        class MyScanner{
            BufferedReader br;
            StringTokenizer st;
        
            public MyScanner() {
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
        
        ```

    - BOJ_2470

        ```java
        import java.util.Arrays;
        
        public class BOJ_2470 {
        
        /**
             * -10만~ 10만=최대치int가능
        		 * TODO : A[left]랑 더해서0에 가까운 오른쪽 용액은?
        		 * = "-A[left]"와 가까울 수록 좋다=정렬하면 가장 가까운 원소 양옆에 있다.
        	 	 * 정렬하면, 1.이분탐색 가능, 2.가장 가까운 원소 빠르게 가능
        */
        static int N;
            static int[]arr;
        
            static MyReadersc= new MyReader();
            static StringBuildersb= new StringBuilder();
        
            static void input() {
        				N=sc.nextInt();
        				arr= new int[N+ 1];
        				        for (int i = 1; i <=N; i++) {
        				arr[i] =sc.nextInt();
        		}
        
            }
        
            static int lower_bound(int[] A, int L, int R, int X) {
                //TODO : A[L .. R]에서 X **이상**의 수 중 제일 왼쪽 인덱스를 return
        			//그런게 없다면 R + 1 return A[L X (X+1) R]
        
        			int res = R + 1;
                while (L <= R) {
                    int mid = (L + R) / 2;
                    //** warning X **이상** 의 수 중 가장 왼쪽 인덱스.
                    if (A[mid] >= X) {// A[L X mid R res]
                        res = mid;
                        R = mid - 1;  // A[L X R mid=res]
                    } else {          // A[L mid X R res]
                        L = mid + 1; // A[mid L X R res]
                    }
                }
                return res;
            }
            static void pro() {
                //TODO : arr이분탐색 할거니까 일단 정랼
        Arrays.sort(arr,1,N+1);
        
                int best_sum = Integer.MAX_VALUE;
                int v1 = 0, v2 = 0;
                for (int left = 1; left <=N- 1; left++) {
                    //TODO : arr[left]용액을 쓸 것이니 -arr[left]와 가장 가까운용액을 자신의 오른쪽에서 찾자
        //= -arr[left]를 이분 탐색으로 찾자
        				int res =lower_bound(arr, left + 1,N, -arr[left]);
        
                    //TODO : arr[res - 1]와 arr[res]중에 arr[left]랑 더했을 떄 정보 갱신
        if (left < res - -1  && Math.abs(arr[res - 1] +arr[left]) < best_sum) {
                        best_sum = Math.abs(arr[left] +arr[res - 1]); //갱신
        
                        v1 =arr[left];
                        v2 =arr[res - 1];
                    }
        
                    if (res <=N&& Math.abs(arr[res] +arr[left]) < best_sum) {
                        best_sum = Math.abs(arr[left] +arr[res]);
        
                        v1 =arr[left];
                        v2 =arr[res];
                    }
                }
        
        					sb.append(v1).append(' ').append(v2);
        			        System.out.println(sb);
        
            }
        
            public static void main(String[] args) {
        				input();
        				pro();
        				
            }
        }
        
        ```