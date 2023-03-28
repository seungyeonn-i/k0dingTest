- “위상” + “정렬”
    - Directed Acyclic Graph(DAG)
        - 방향성이 있고 사이클이 없는 그래프
        - DAG에서는 차수를 Indegree(정점으로 들어가는) / Outdegree(나오는) 로 구별
    - 위상
        - 간선의 방향성을 어떤 조건에 따라 간선 번호를 수열에 맞게 정렬
        - 어떤 순서로 정렬이 되냐 모든 간선마다 정점들을 위상에 맞춰 정렬
        - DAG에서만 적용
        - 즉, 간선마다 방향의 순서에 맞추어 정렬해야한다.
- 알고리즘
    1. 정점들의 indegree, indeg[1..N] 계산
    2. 순간마다 **들어오는 간선이 0개인 (indeg[i] == 0)인 정점**찾아 자료구조 D에 넣기

       → 자료구조 D는 원소 추가,꺼내기 연산을 사용하는데, 이것을 빠르게 해주는 것은 Queue

        ```java
        Deque<Integer> queue = new LinkedList<>();
        
        for(int i=1;i<=N;i++){
        	if(indeg[i] == 0)
        		queue.add(i);
        }
        ```

    3. D가 빌 때까지
        1. D에서 원소 x를 꺼내서 정렬 시키기
        2. ~~Graph에서~~ 정점 X 제거 하기
        3. 새롭게 정렬 가능한 점 찾아서 자료구조 D에 넣기

        ```java
        while(!q.isEmpty()){
        	int x = que.poll() // x꺼내고 제거 
        	sb.append(x).append(' '); // 정렬 
        	for(int y : adj(x)){
        		indeg[y]--; // 제거한 정점의 간선 indegree x제거
        		if(indeg[y] == 0) que.add(y); // y라는 정점이 que에 1번만 들어감을 보장해야함
        																	// 위의 indeg[y]--가 있음으로 1번을 보장할 수 있음
        	}
        }
        ```


---

- BOJ_2252

  > 학생들을 키 순으로 정렬
  학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.
  >
    - graph 만들어보기
        - 정점(V) : i번 학생이 곧 i번 정점
        - 간선(E) : x번 학생이 y번 학생보다 먼저 서야한다.
    - 구현

        ```java
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
        	for(int i=1;i<=N;i++){
        		if(indeg[i] == 0) queue.add(i);
        	}
        	while(!queue.isEmpty()){
        		int x = queue.poll();
        		sb.append(x).append(' ');
        		for(int y : adj[x]){
        			indeg[y]--;
        			if(indeg[y] == 0) queue.add(y);
        		}
        	}
        	System.out.println(sb);
        }
        
        ```


- BOJ_1005

  먼저 지어져야 하는 건물 짓고 최소시간안에 모든 건물 다 짓기

    - 정답의 최대치
        - 10^3(최대 갯수) *10^5(최대 시간) = 10^8 → Integer 충분
    - 알고리즘
        - Tdone[X] = X 건물이 완성되는 시간
          = max(Tdone[X의 선행작업]) + T[X]
        - Tdone[X]를 계산하기 위해서는, X의 선행작업들이 먼저 계산 되어야한다.

          → Tdone 배열을 위상 정렬 순서로 계산하면 된다.

    - 구현

        ```java
        static void input(){
        	// Testcase가 존재하는 문제이므로 "배열 초기화"에 유의
        }
        static void pro(){
        	Deque<Integer> queue = new LinkedList<>();
        	// 제일 앞에 정렬될 수 있는 정점 찾기
        	for(int i=1;i<=N;i++)
        		if(indeg[i] == 0){
        			queue.add(i);
        			T_done[i] = T[i];
        		}
      }   
        
        	while(!queue.isEmpty()){
        		int x = queue.poll();
        		for(int y : adj[x]){
        			indeg--;
        			if(indeg[y] == 0) queue.add(y);
        			// TODO : 
        			T_done[y] = Math.max(T_done[y],T_done[x] + T[y]);
        		}
        		int W = sc.nextInt();
        		System.out.println(T_done[W]);
        	}
        	
        	
        	// 위상 정렬 순서대로 T_done 계산을 함께 해주기
        }
        
        ```