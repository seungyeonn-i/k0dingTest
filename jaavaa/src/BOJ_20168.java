import java.util.*;

public class BOJ_20168 {
    static int N,M,A,B,C;
//    static int[][] adj;
    static int[] dist;
    static ArrayList<Info>[] edges;
    static long[] d;
    static long INF = 10000000000000001L;


    static Scanner sc = new Scanner(System.in);
    static void input() {
        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        edges = new ArrayList[N+1];
        d = new long[N + 1];


        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            long weight = sc.nextLong();
            edges[from].add(new Info(to, weight));
            edges[to].add(new Info(from, weight));
        }
    }
    static class Info{
        int idx;
        long length;

        public Info(int idx, long length) {
            this.idx = idx;
            this.length = length;
        }
    }
//    static class Edge{
//        int to;
//        int weight;
//
//        public Edge(int to, int weight) {
//            this.to = to;
//            this.weight = weight;
//        }
//    }
/*
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
        System.out.println(dist[B]);

    }
    */

    static boolean dijkstra(long x) {
        for (int i = 1; i <= N; i++) d[i] = INF;
        d[A] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.length));

        pq.add(new Info(A, 0));
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if(d[cur.idx] != cur.length) continue;
            for (Info edge : edges[cur.idx]) {
                if (edge.length > x) continue;
                if (d[edge.idx] > d[cur.idx] + edge.length) {
                    d[edge.idx] = d[cur.idx] + edge.length;
                    pq.add(new Info(edge.idx, d[edge.idx]));
                }
            }
        }
        return d[B] <= C;
    }



    static void pro() {
        d = new long[N + 1];
        long left = 1, right = 1000000001, ans = right;
        while (left <= right) {
            long mid = left = right /2;

            if (dijkstra(mid)) {
                ans = mid;
                right = mid = -1;
            }else{
                left = mid + 1;
            }
        }
        if(ans == 1000000001) ans = -1;
        System.out.println(ans);
    }



    public static void main(String[] args) {
        input();
        pro();

    }

}
