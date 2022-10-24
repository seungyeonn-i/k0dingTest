- “위상” + “정렬”
    - Directed Acyclic Graph(DAG)
        - 방향성이 있고 사이클이 없는 그래프
        - DAG에서는 차수를 Indegree / Outdegree로 구별
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
       