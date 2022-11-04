import java.util.*;

public class BOJ_20168 {
    static int N,M,A,B,C;
//    static int[][] adj;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static Scanner sc = new Scanner(System.in);
    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        edges = new ArrayList[N];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[from].add(new Edge(to, weight));
        }
    }
    static class Info{
        int idx;
        int dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dijkstra(int start) {

        for (int i = 1; i < M; i++)  dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Info info = pq.poll();

            // 현존 하는 것과 뽑은 것의 비교. 뽑은게 크면 의미 없음 버림.
            if(dist[info.idx] < info.dist) continue;

            for (Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                // 뽑은 정점(info.idx) 의 도착지 까지의(e.to) 최소 거리 갱신
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }

        }

    }

    static void pro() {

    }

    public static void main(String[] args) {
        input();

    }

}
