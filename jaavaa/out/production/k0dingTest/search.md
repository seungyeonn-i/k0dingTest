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

- 매개 변수 탐색
    - 배열이 0과 1만 존재하며 오름차순인건 보장이 되지만, 전체 배열은 모른다.
      특정 인덱스 값을 O(T)에 계산 가능 할 때, 여기서 0과 1의 경계를 찾아야한다면?
        - 1부터 1000까지 전부, “생각한 숫자가 1,2,3,4,…1000 이상이야?” → O(1000T)
        - “생각한 숫자가 500,750,…이상이야?” → 조건에 맞지 않는 구간 처리 → O(Tlog1000) → O(10T)
    - 핵심
        1. 정답을 “**매개변수**”로 만들고 **Yes/No(결정 문제)**로 바꿔 보기
        2. 모든 값에 대해 Yes/No를 채웠다고 생각했을 때, **정렬 된 상태인가**?
        3. Yes/No 결정하는 문제를 **풀기**
    - 주의 사항
        1. 매개 변수에 대한 결정이 Nooooooo Yessssss 가 아닌데 확인하지 않고 이분 탐색 주의
        2. L,R,M,Result 변수의 정의를 헷갈려 부등호 주의
        3. L,R의 범위를 잘못 설정하거나 Result의 초기값 설정 주의
    - 키워드
        - ~ 의 최댓값,최솟값 을 구하시오
    - pro() 부분은 기계적, determination 부분 변형 중요

        ```java
        static void determination(int D){
            // TODO : 매개변수 변환 문제 해결
        }
        static void pro(){
            // TODO : 기계적 양식임
            Arrays.sort(A,1,N+1);
            while(L <= R){
                int mid = (L + R) /2 ;
                if(determination(mid)){
                        ans = mid;                     // ans 업데이트 
                        L = mid + 1;                  // 정확한 ans를 찾기위한 범위 좁히기
                }else{
                        R = mid - 1;
                }
        }
        ```java


    ---
    
    - BOJ_2805
        - 나무 갯수 N , 필요한 나무 길이 M
        - 정답의 최대치
            - N = 100만, M = 20억 정답 범위 0 ~ 10억 → int 
            but, 계산 과정중, 잘린 나무의 길이 합 ≤ 나무 높이의 총합 =10^15 → long
        - 키워드 체크
            - 적어도 M미터의 나무를 집에 가져가기 위해 절단기에 “**설정할 수 있는 높이의 최댓값**”을 구해라 → 매개 변수 탐색
                - [x]  정답을 “**매개변수**”로 만들고 **Yes/No(결정 문제)**로 바꿔 보기
                - [x]  모든 값에 대해 Yes/No를 채웠다고 생각했을 때, **정렬 된 상태인가**?
                - [x]  Yes/No 결정하는 문제를 **풀기**
        - 매개 변수 만들기
            - **원하는 길이 M만큼 얻을 수 있는** 최대 **높이**는 얼마 인가
            → 어떤 **높이(H)**로 잘랐을 때 **원하는 길이 M을 얻을 수 있는가** → O(N)
        
        ```java
        import java.util.Scanner;
        
        public class BOJ_2805 {
        
            static intN,M;
            static int[]arr;
            static Scannersc= new Scanner(System.in);
            static StringBuilderstringBuilder= new StringBuilder();
            static void input() {
        N=sc.nextInt();
        M=sc.nextInt();
        arr= new int[N+1];
                for (int i = 1; i <=N; i++) {
        arr[i] =sc.nextInt();
                }
            }
        
            static boolean determination(int H) {
                // H 높이로 나무를 잘랐을 때 M만큼 얻을 수 있으면 true, 없으면 false
                // 자른 나무의 총 길이 합 long 이여야함
        
                long sum = 0;
                for (int i = 1; i <=N; i++) {
                    if (arr[i] > H) {
                        sum +=arr[i] - H;
                    }
                }
                return sum >=M;    // M 이상 얻을 수 있으면 true
            }
        
            static void pro() {
                long L = 0, R = 2000000000, ans = 0;
        
                //[L .. R]사이에 정답 존재한다
                //TODO :이분 탐색과 determination문제를 이용해 answer구하기
        
        while (L <= R) {
                    long mid = (int) ((L + R) / 2);
        
                    if (determination((int)mid)) {
                        ans = mid;       //가능하면 저장
                        L = mid + 1;    //하고 왼쪽 떙겨오기
                    }else{
                        R = mid - 1;
                    }
                }
                System.out.println(ans);
            }
        
            public static void main(String[] args) {
        input();
        pro();
            }
        }
        
        ```java
        
    - BOJ_2110
        - 정답 최대치
            - 제일 멀리 설치 해보면 정답은 10억이하 → integer
        - 가장인점한 두 공유기 사이의 거리를 **최대로** 하는 프로그램 → 매개변수 만들기
            - C개의 공유기를 설치했을 때 최대 인접 거리는 얼마인가
                
                → 어떤 거리만큼 거리를 둘 때 공유기 C개를 설치할 수 있는가 Yes/No
                
            - 어떤 거리만큼 거리를 둘 때 왼쪽 집부터 되는대로 전부 설치 해보기
                
                ![스크린샷 2022-10-15 오전 11.39.24.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/57a6afac-5f12-494c-a6b9-5f1c3c01523d/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-10-15_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_11.39.24.png)
                
        - 뒤집은 문제를 모든 거리(D) 마다 해보면 (1^10억) 해보면 마지막 Yes가 정답
        시간 복잡도 : O(뒤집은 문제xlog 10억) = O(N x log X) = N x 30
        - 주어진 집 정렬 > D를 정해서 결정 문제 한 번 풀기 > 정답 범위를 이분 탐색 하면서 풀기
            
            ```java
            import java.io.BufferedReader;
            import java.io.IOException;
            import java.io.InputStreamReader;
            import java.util.Arrays;
            import java.util.StringTokenizer;
            
            public class BOJ_2110 {
                /**
                 * 최 대 거 리
                 * 어떤 거리만큼 거리를 둘 때 공유기 c개를 설치할 수 있는가
                 *
                 */
            
                static int C,N;
                static int[] A;
            
                static MyScanner sc = new MyScanner();
                StringBuilder sb = new StringBuilder();
                static void input() {
                    N = sc.nextInt();
                    C = sc.nextInt();
            
                    A = new int[N + 1];
                    for (int i = 1; i <= N; i++) {
                        A[i] = sc.nextInt();
                    }
            
                }
            
                static boolean determination(int D) {
                    // TODO : D만큼의 거리를 둔다면 C개 만큼 공유기를 설치할 수 있나
            
                    // 가장 많이 설치해보자
                    // 제일 왼쪽부터 설치, D만큼 거리를 두며 최대로 설치가 개수와 C를 비교
                    int cnt = 1, last = A[1];   //설치 갯수, 마지막으로 설치한 index
                    for (int i = 2; i <= N; i++) {
                        //A[i] 번쨰 설치 가능?
                        if (A[i] - last >= D) {
                            cnt++;
                            last = A[i];
                        }
                    }
                    return cnt >= C;
                }
            
                static void pro() {
                    // 빠른 determination을 위한 정렬
                    int L = 1, R = 10000000, ans = 0;
                    Arrays.sort(A,1,N+1);
            
                    // [L ... R] 범위 안에 정답 존재
                    // 이분 탐색과 determination 문제를 이용해 ans 구하기
                    while (L <= R) {
                        int mid = (L + R) / 2;
                        if (determination(mid)) {
                            ans = mid;
                            L = mid + 1;
                        }else{
                            R = mid - 1;
                        }
                    }
            
                    System.out.println(ans);
                }
            
                public static void main(String[] args) {
            
                }
            
            }
            class MyScanner{
            
                BufferedReader br;
                StringTokenizer st;
            
                public MyScanner(){
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
            
                Long nextLong() {
                    return Long.parseLong(next());
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
            ```java
            
    - MyScanner
        
        ```java
        class MyScanner{
            BufferReader br;
            StringTokeniger st;
        	
            public MyScanner(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        
            String next(){
                while(st == null || !st.hasMoreElements()){
                        try{
                            st = new StringTokeniger(br.readLine());
                        }catch(IOException e){
                                e.printStackTrace();
                        }
                }
                return st.nextToken();
            }
        
            int nextInt(){
                    return Integer.parseInt(next());
            }
        	
            long nextLong(){
                    return Long.parseLong(next());
            }
        	
            double nextDouble(){
                    return Double.parseDouble(next());
            }
        	
            String nextLine(){
                    String str = "";
                    try{
                        str = br.readLine();
                    } catch(IOException e){
                            e.printStackTrace();
                    }
                    return str;
            }
        ```java

    - 투 포인터
    
    > 굳이 정답을 찾기 위해 모든 부분을 봐야하는가?
    > 
    
    - 화살표 두 개에 의미를 부여해서 탐색 범위를 압축하는 방법
        1. 1차원 배열 위에 2개의 포인터를 만드는 경우
            1. 2개의 포인터가 모두 왼쪽에서 시작해 같은 방향으로 이동
                
                R이 3칸 가면, L이 1칸 , 그럼 또 R이 또 감, L이 쫓아감
                
            2. 2개의 포인터가 양 끝에서 서로를 향해 이동
        2. 관찰을 통해서 문제에 등장하는 변수 2개의 값을 두 포인터로 표현하는 경우
    - 꿀 팁 키워드
        - 1차원 배열에서의 “연속 부분 수열” || “순서를 지키며 차례대로”
        - 곱의 최소
            - A가 커지면 B가 작아지니까, 하나가 늘면 하나가 줄어드니까
    
    ---
    
- BOJ_1806
        
        > **연속된 수**들의 부분합중에 그 합이 S 이상이 되는 것 중 가장 짧은 것의 길이
        > 
        - 원소의 개수 N, 기준합 S,
        - 정답의 최대치
            - N = 100,000
            S = 10^8
            - 정답이 N이하, 100,000이하 → Intger 범위
            모든 원소의 총합도 10^9(10^5*10^4) → Intger 범위
            1. 왼쪽 시작 L결정 > 오른쪽 끝을 R을 L부터 시작해서 이동 하며 S 넘는지 확인 → O(N^2) 
            2. 왼쪽 시작 L의 이동 > 오른쪽 끝 R을 이전의 R부터 시작해서 이동  → O(N)
        - 구현
            
            ```java
            static void pro(){
            	int R = 0, sum = 0, ans = n + 1; //ans=s를 넘는 값들 중 가장 짧은거 기록
            	for(int L = 1;L <= n;L++){
            		// L - 1 을 구간에서 제외하기
            		sum -= a[L - 1];
            		// R을 옮길 수 있을 때까지 옮기기 (합이 S보다 커지는 순간 멈춤)
            		while(R + 1 <= n && sum < S)
            		{
            				R++;
            				sum += a[R];
            		}
            		//[L...R]의 합, 즉 sum이 조건을 만족하면 정답 갱신
            		if(sum >= S){
            				ans = Math.min(ans, R - L + 1);
            		}
            	}
            	//ans값 보고 불가능 판단하기
            	if(ans == n + 1){//min이 갱신이 안됐다면
            			ans = 0;
            	}
            	System.out.println(ans);
            }
            ```java
            
    - BOJ_2470
        - 알고리즘
        
            가장 작은수(-99) 랑 가장 큰 수(98) 랑 더해도 음수인데, 그보다 덜 작은수(-1,-2), 덜 큰수랑 더하면 안더해도 음수다. -99 + 98은 이미 좋은 애랑 했다. 
            
            - 최소 + 최대 < 0
                
                → 최소 입장에서는 최선책을 만난 상태, 짝을 찾았으니 최소(-99) 삭제
            
            다음으로, 98이랑 -2랑 더하면 합이 양수 최대 입장에서, 굳이 덜 작은 수(-1)이랑 덜 큰수(4)를 더해야할까?
            
            - 최소 + 최대 > 0
                
                → 최대 입장에서는, 최선택을 만난 상태, 짝을 찾았으니 최대(98) 삭제
                             
            - 이건 O(N^2) . ~~시발~~ 정렬하면 더 빨리 됨
        - 정렬 > L,R 계산 후에 이동 > O(N log N)
        
        ```java
        static void pro(){
        
        	Arrays.sort(A,1,N+1);
        
        	int best_sum = Intger.MAX_VALUE;
        	int v1 = 0, v2 = 0, L = 1, R = N;
        	
        	while(L < R){
        		int sum = A[L] + A[R];
        		if(Math.abs(sum) < best_sum){
        			best_sum = Math.abs(sum);
        			v1 = A[L];
        			v2 = A[R];
        		}
        		if( sum > 0 ){
        				R--;
        		}else L++;
        		sb.append(v1).append(' ').append(v2);
        		System.out.println(sb);
        }
        ```java
        
    - BOJ_13144
        
        > 수열에서 **연속한** 1개 이상의 수 뽑을 때 같은수가 여러번 등장하지 않는 경우의 수
        > 
        - 정답의 최대치
            - N + (N-1) + (N-2) … = 50억 → Long
        - O(N^3)의 방법
            - 1️⃣ 왼쪽 시작 L > 2️⃣ 오른쪽 끝 R을 L부터 시작 > 3️⃣ R을 이동하여 추가된 원소가 기존 구간 [L,R-1]안에 있는지 확인
        - O(N^2)의 방법
            - 위의 “R을 이동하여 추가된 원소가 기존 구간 [L,R-1]안에 있는지 확인” 에서  숫자마다 **[L,R] 안에 몇 개나 있는지를 세자** > 최대 숫자 알기에 count 배열 생성 가능
            - 1️⃣ 왼쪽 시작 L > 2️⃣ 오른쪽 끝 R을 L부터 시작해서 이동 > 3️⃣ R을 이동해 추가된 원소가 [L,R-1] 안에 있는지 확인 O(1) << count 배열 사용 >>
        - O(N)의 방법
            - 또한, 1~3 중복된게 없다면 1~2,2~3에도 중복된게 없음 :: 경우의 수 셀 때 참고
            - [L…R] 중에 L기준 R까지 가는 경우의 수
                
                ex)  [1,L2,3,R1,2] 에서, L=2일때, R=2,R=3,R=1 → 경우의 수 3 …
                
            - 1️⃣ 왼쪽 시작 L > 2️⃣ 오른쪽 끝 R을 이전 R부터 시작 > 3️⃣ L,R이 각자 최대 N번 이동
        - 구현
        
        ```java
        static void input(){
        	N = sc.nextInt();
        	A = new int[N + 1];
        	for(int i=1;i<=N;i++){
        		A[i] = sc.nextInt();
        	}
        	cnt = new int[100000 + 1];
        }
        
        static void pro(){
        	long ans = 0;
        	for(int L=1,R=0; L<=N;L++){
        		// TODO : R을 옮길 수 있을 만큼 옮긴다
        		while( R+1<=N && cnt[A[R+1]] == 0){   // R을 옮겨도 N을 넘어가면 안되며, 
        																				// 옮긴 위치 숫자가 L~R사이에 있으면 안됨 
        				R++;
        				cnt[A[R]]++;
        		}
        		// TODO : 정답을 갱신한다
        		ans += R - L + 1;
        		// TODO : L을 옮겨주면서 A[L]의 개수를 감소시킨다.
        		cnt[A[L]]--;
        	}
        	System.out.println(ans);
        ```java
        
    - BOJ_1253
        
        > N개의 수 중에서 어떤수가 다른 수 두개의 합으로 나타낼 수 있을 때, 그 갯수
        > 
        - O(N^3) 의 방법
            
            1️⃣ 타겟을 정한다 O(N) > 2️⃣ 나머지에서 2개 결정해서 만들어지나 확인 O(N^2) 
            
        - O(N^2) 의 방법
            
            1️⃣ 정렬을 한다 > 2️⃣ 타겟을 정한다 > 3️⃣ 나머지에서 다른수 2개로 (두 용액문제 풀이와 같음)
            
        - 구현
            
            ```java
            static boolean func(int tartget_idx){
            	// target_idx 번쨰 원소가 서로 다른 두 수의 합으로 표현 되는가
            	int L = 1, R = N;
            	int target = A[target_idx];
            	while( L < R){
            		// TODO : 
            		if(L == target_idx) L++;
            		else if(R == target_idx) R--;
            		else{
            			if(A[L] + A[R] == target) return true;
            			if(A[L] + A[R] > target) R--;//warning
            			else L++;
            		}
            	}
            	return false;
            }
            
            static void pro(){
            	// TODO : 최소, 최대를 빠르게 알기 위한 정렬
            	Arrays.sort(A,1,N+1);
            
            	int ans = 0;
            	for(int i=1;i<=N;i++){
            		// TOOD : i번쨰 원소가 서로 다른 두 수의 합으로 표현이 되는가
            		if(func(A[i]))
            			ans++;
            	}
            	System.out.println(ans);
            }
            ```java
            
    - BOJ_16472
        
        > 최대 N개 종류의 알파벳을 가진 **연속된 최대 문자열**의 길이
        > 
        - 정답의 최대치
            - N = 26일 때, 문자열 전체 인식하므로 최대 길이인 10만이 정답 → int
        - 투 포인터 접근의 변형
            - L = 인식 가능한 가장 왼쪽 위치
            - R = 인식하고 싶은 구간의 오른쪽 끝
            - cnt = 알파벳 갯수 배열
            - kind = [L,R] 사이의 알파벳 종류 = cnt 배열에서 0이 아닌 것의 갯수
                
                → R을 이동하며 [L,R] 사이의 알파벳 종류 갯수 → kind와 N을 비교하며 L의 위치 변경
                
        - 시간 복잡도
            - R을 하나씩 이동하면서 L을 조절하기 O(N)
            - kind를 O(26)→O(1) 가능
        - 구현
            
            ```java
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
            	System.out.println(ans);
            }
            ```java