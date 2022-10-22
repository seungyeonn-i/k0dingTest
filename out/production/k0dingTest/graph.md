- 자료구조로서 그래프 = 정점(Vertex) + 간선(Edge)
- 용어 정리
    - 간선(Edge) → (무방향 / 방향) + 가중치
        - 무방향(=양방향)
        - 방향 : 화살표 끝에 방향을 나타냄
        - 가중치
    - 정점의 차수(Degree)
        - deg(x) := 정점 x에 연결된 간선의 수
        - 모든 정점 차수의 합 = 간선 개수의 2배
            - 간선이 1 증가하면 차수의 합은 2 증가 한다.
- 그래프를 저장하는 방법
    
    |  | 인접 행렬 | 인접 리스트 |
    | --- | --- | --- |
    | A와 B를 잇는 간선 존재 여부 | O(1) | O(min(deg(A),deg(B))) |
    | A와 연결된 모든 정점 확인 | O(V) | O(deg(A)) |
    | 공간 복잡도 | O(V^2) | O(E) |
    - 인접 행렬 (Adjacency Matrix)
        - 2차원 행렬로 표현
        - O(V^2)만큼 공간 필요 → 구현하기 쉽지만 메모리 이슈가 있다
        - ex) A에서 B로 이동 가능? 가중치 얼마? → adj(A,B) 값 리턴 → O(1)
        - ex) 정점 A에서 갈 수 있는 정점들은? → O(V)
        
    - 인접 리스트 (Adjacency List)
        - A 정점에서 갈 수 있는 정점들을 인접 리스트에 담는다.
        - ArrayList<ArrayList<Integer>> adj;
        - 총 O(E) 만큼의 공간 필요 = 모든 정점의 차수의 합과 동일
        - ex) A에서 B로 이동 가능? 가중치 얼마?
            
            → adj(A)에서 B 확인 → O(min(deg(A),deg(B))) <<양방향성 그래프일 경우>>
            
            → adj(A)에서 B 확인 → O(deg(A)) <<방향성 그래프일 경우>>
            
- 그래프에서의 탐색
    - 깊이 우선 탐색(**D**epth **F**irst **S**earch)
        - 구현
            
            ```java
            // x를 갈 수 있다는 걸 알고 방문한 상태
            static void dfs(int x){                   // -> 모든 정점이 x로 한번씩만 O(V) 
            		// x 방문
            		visit[x] = true;
            		
            		// x에서 갈 수 있는 곳들을 모두 방문
            		for(int y : x에서 갈 수 있는 점 들){       // -> 인접행렬 O(V) || 인접리스트 O(deg(x))
            				if(visit[y])     // visit[y]가 true면 이 y는 무시
            					continue;
            
            				// 아직 안가본 y라면 가보자
            				dfs(y);
            		}
            }
            ```
            
            - 인접 행렬 → O(V^2)
            - 인접 리스트 → O(deg(1) + deg(2) + … + deg(V)) = O(E)
    - 너비 우선 탐색(**B**reath **F**irst **S**earch)
        - 구현
            
            ```java
            // start에서 시작해 갈 수 있는 정점 모두 탐색
            static void bfs(int start){
            		Queue<Integer> que = new LinkedList<>();
            		
            		//start는 방문 가능, que에 add
            		que.add(start);
            			visit[start] = true;    // !!! start를 갈 수 있다고 표시
            
            		while(!.que.isEmpty()){  // 더 확인할 점이 없다면 정지
            				int x = que.poll();
            
            				for(int y : x에서 갈 수 있는 점들){
            						if(visit[y]) continue;
            
            						que.add(y);
            						visit[y] = true;
            				}
            		}
            }
            ```